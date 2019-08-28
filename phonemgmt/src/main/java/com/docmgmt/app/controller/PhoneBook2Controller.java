package com.docmgmt.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.docmgmt.app.entity.UserCompanyDetail;
import com.docmgmt.app.repo.UserCompanyDetailRepo;
import com.docmgmt.app.service.CrudReturnService;

@RestController
@RequestMapping("phonebook2")
public class PhoneBook2Controller {

	@Autowired
	CrudReturnService<UserCompanyDetail> crudReturnService;
	
	@Autowired
	UserCompanyDetailRepo userCompanyDetailRepo;
	
	@GetMapping(path = "/view-page")
	public ModelAndView viewpage() {
		ModelAndView model = new ModelAndView("phonebook2");
		model.addObject("pagetitle", "THE PHONE BOOK");
		return model;
	}
	
	@GetMapping(path = "/")
	public ResponseEntity<?> read() {
		List<UserCompanyDetail> list = userCompanyDetailRepo.findAll();

		ResponseEntity<?> returntype = crudReturnService.controllerReturnForList(list);
		return returntype;
	}
}
