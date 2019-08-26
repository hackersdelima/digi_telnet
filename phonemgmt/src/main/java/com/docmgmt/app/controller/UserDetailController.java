package com.docmgmt.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.docmgmt.app.service.AdminService;
import com.docmgmt.app.service.CrudReturnService;
import com.docmgmt.app.exception.ProductNotfoundException;
import com.docmgmt.app.exception.ValidationErrorException;
import com.docmgmt.app.message.HttpResponses;
import com.docmgmt.app.message.Messages;
import com.docmgmt.app.repo.UserDetailRepo;

import com.docmgmt.app.entity.UserDetail;

@RestController
@RequestMapping("users")
public class UserDetailController {

	@Autowired
	UserDetailRepo userDetailRepo;
	
	@Autowired
	CrudReturnService<UserDetail> crudReturnService;
	
	@Autowired
	AdminService adminService;
	
	//UI connection
		@GetMapping(path = "/create-page")
		public ModelAndView createpage() {
			ModelAndView model = new ModelAndView("user/create");
			model.addObject("pagetitle", "USERS");
			return model;
		}

		@GetMapping(path = "/view-page")
		public ModelAndView viewpage() {
			ModelAndView model = new ModelAndView("user/view");
			model.addObject("pagetitle", "USERS");
			return model;
		}

		@GetMapping(path = "/")
		public ResponseEntity<?> read() {
			List<UserDetail> list = userDetailRepo.findAll();

			ResponseEntity<?> returntype = crudReturnService.controllerReturnForList(list);
			return returntype;
		}

		@GetMapping(path = "/{id}")
		public ResponseEntity<Messages> read(@PathVariable int id) {
			try {
				UserDetail userDetail = userDetailRepo.findById(id).get();
				if (userDetail != null) {
					return new ResponseEntity<Messages>(HttpResponses.fetched(userDetail), HttpStatus.OK);
				}
			} catch (Exception e) {
			}
			return new ResponseEntity<Messages>(HttpResponses.notfound(), HttpStatus.NOT_FOUND);

		}

		@PostMapping
		public ResponseEntity<Messages> create(@Validated @RequestBody UserDetail detail, BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
				throw new ValidationErrorException(bindingResult);
			} else {
				UserDetail userDetail = userDetailRepo.save(detail);

				ResponseEntity<Messages> returntype = crudReturnService.updateReturn(userDetail);
				return returntype;
			}
		}

		@DeleteMapping(path = "/{id}")
		public ResponseEntity<Messages> delete(@PathVariable int id) {
			try {
				if (id > 1) {
					UserDetail userDetail = userDetailRepo.findById(id).get();
					if (userDetail == null) {
						throw new ProductNotfoundException();
					} else {
						userDetailRepo.deleteById(id);
						
						return new ResponseEntity<Messages>(HttpResponses.received(), HttpStatus.ACCEPTED);
					}
				}

			} catch (Exception e) {
			}
			throw new ProductNotfoundException();

		}
}
