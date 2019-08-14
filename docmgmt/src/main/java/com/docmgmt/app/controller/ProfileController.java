package com.docmgmt.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.docmgmt.app.entity.Staffs;
import com.docmgmt.app.entity.Users;
import com.docmgmt.app.message.HttpResponses;
import com.docmgmt.app.message.Messages;
import com.docmgmt.app.repo.StaffsRepo;
import com.docmgmt.app.repo.UsersRepo;

@RestController
@RequestMapping("/userprofiles")
public class ProfileController {
	
	@Autowired
	UsersRepo usersRepo;
	
	@Autowired
	StaffsRepo staffsRepo;

	@GetMapping(path="/user-profile")
	public ModelAndView viewprofile(Authentication authentication) {
		ModelAndView model=new ModelAndView("profiles/profile");
		model.addObject("pagetitle","PROFILES");
		
		Users current_user=getCurrentUser(authentication);
		model.addObject("cuser", current_user);
		
		return model;
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Staffs staffs, Authentication authentication) {
		try {
		Users current_user=getCurrentUser(authentication);
		Staffs current_staff=current_user.getStaffs();
		String current_s_code=current_staff.getCode();
		
		Staffs s=staffsRepo.findById(current_s_code).get();
		s.setFirstName(staffs.getFirstName());
		s.setLastName(staffs.getLastName());
		s.setPhoneNumber(staffs.getPhoneNumber());
		
		Staffs savedStaffs=staffsRepo.save(s);
		
		if(savedStaffs!=null) {
			return new ResponseEntity<Messages>(HttpResponses.created(savedStaffs), HttpStatus.CREATED);
		}
		
		}
		catch (Exception e) {
			System.out.println(e);
		}
			return new ResponseEntity<Messages>(HttpResponses.badrequest(), HttpStatus.BAD_REQUEST);
	}
	
	public Users getCurrentUser(Authentication authentication) {
		String current_username=authentication.getName();
		Users current_user=usersRepo.findByUsername(current_username);
		return current_user;
	}

}
