package com.docmgmt.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.docmgmt.app.dto.AdminDto;
import com.docmgmt.app.entity.Admin;
import com.docmgmt.app.exception.ProductNotfoundException;
import com.docmgmt.app.exception.ValidationErrorException;
import com.docmgmt.app.message.HttpResponses;
import com.docmgmt.app.message.Messages;
import com.docmgmt.app.repo.AdminRepo;
import com.docmgmt.app.service.AdminDtoConversionService;
import com.docmgmt.app.service.AdminService;
import com.docmgmt.app.service.CrudReturnService;

@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	AdminRepo adminRepo;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	CrudReturnService<AdminDto> crudReturnService;

	@Autowired
	AdminDtoConversionService adcs;

	@Autowired
	AdminService adminService;

	// UI connection
	@GetMapping(path = "/create-page")
	public ModelAndView createpage() {
		ModelAndView model = new ModelAndView("admin/create");
		model.addObject("pagetitle", "ADMIN");
		return model;
	}

	@GetMapping(path = "/view-page")
	public ModelAndView viewpage() {
		ModelAndView model = new ModelAndView("admin/view");
		model.addObject("pagetitle", "ADMIN");
		return model;
	}

	@GetMapping(path = "/")
	public ResponseEntity<?> read() {
		List<Admin> listAll = adminRepo.findAll();

		// using dto to only get the required values from db
		AdminDto adminDto = null;
		List<AdminDto> list = new ArrayList<AdminDto>();

		for (Admin a : listAll) {
			adminDto = new AdminDto();
//			try {
//				BeanUtils.copyProperties(a, adminDto);
//				
//			}
//			catch (Exception e) {
//				System.out.println(e);			
//			}
			adminService.createDto(a, adminDto);
			list.add(adminDto);
		}

		ResponseEntity<?> returntype = crudReturnService.controllerReturnForList(list);
		return returntype;
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Messages> read(@PathVariable int id) {
		try {
			Admin admin = adminRepo.findById(id).get();
			if (admin != null) {
				return new ResponseEntity<Messages>(HttpResponses.fetched(admin), HttpStatus.OK);
			}
		} catch (Exception e) {
		}
		return new ResponseEntity<Messages>(HttpResponses.notfound(), HttpStatus.NOT_FOUND);

	}

	public Admin updateAdmin(String id, Admin admin) {
		int idvalue = Integer.parseInt(id);
		Admin findAdminByUsername = adminRepo.findById(idvalue).get();
		findAdminByUsername.setStatus(admin.getStatus());
		Admin savedAdmin = adminRepo.save(findAdminByUsername);
		return savedAdmin;
	}

	@PostMapping(value = "/{id}")
	public ResponseEntity<Messages> update(@PathVariable String id, @RequestBody Admin admin) {
		Admin savedAdmin = updateAdmin(id, admin);
		return crudReturnService.updateReturn(savedAdmin);
	}

	@PostMapping
	public ResponseEntity<Messages> create(@PathVariable String id, @Validated @RequestBody Admin admin,
			BindingResult bindingResult) {
		Admin savedAdmin = null;

		if (bindingResult.hasErrors()) {
			throw new ValidationErrorException(bindingResult);
		} else {
			String password = admin.getPassword();
			String confirmpassword = admin.getConfirmpassword();

			if (password.equals(confirmpassword)) {
				String encpassword = passwordEncoder.encode(password);
				admin.setPassword(encpassword);
				savedAdmin = adminRepo.save(admin);
			}
		}
		return crudReturnService.updateReturn(savedAdmin);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Messages> delete(@PathVariable int id) {
		try {
			if (id > 1) {
				Admin admin = adminRepo.findById(id).get();
				if (admin == null) {
					throw new ProductNotfoundException();
				} else {
					adminRepo.deleteById(id);

					return new ResponseEntity<Messages>(HttpResponses.received(), HttpStatus.ACCEPTED);
				}
			}

		} catch (Exception e) {
		}
		throw new ProductNotfoundException();

	}
}
