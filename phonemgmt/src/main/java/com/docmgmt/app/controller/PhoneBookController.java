package com.docmgmt.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.docmgmt.app.entity.UserDetail;
import com.docmgmt.app.repo.UserDetailRepo;
import com.docmgmt.app.service.CrudReturnService;

@RestController
@RequestMapping("phonebook")
public class PhoneBookController {

	@Autowired
	UserDetailRepo userDetailRepo;
	
	@Autowired
	CrudReturnService<UserDetail> crudReturnService;
	
	@GetMapping(path = "/view-page")
	public ModelAndView viewpage() {
		ModelAndView model = new ModelAndView("phonebook");
		model.addObject("pagetitle", "THE PHONE BOOK");
		return model;
	}
	
	@GetMapping(path = "/")
	public ResponseEntity<?> read() {
		List<UserDetail> list = userDetailRepo.findAll();

		ResponseEntity<?> returntype = crudReturnService.controllerReturnForList(list);
		return returntype;
	}
}
