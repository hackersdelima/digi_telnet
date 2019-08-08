package com.docmgmt.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docmgmt.app.entity.Staffs;
import com.docmgmt.app.entity.StaffsFamily;
import com.docmgmt.app.message.HttpResponses;
import com.docmgmt.app.message.Messages;
import com.docmgmt.app.repo.StaffsFamilyRepo;

@RestController
@RequestMapping("staffsFamily")
public class StaffsFamilyController {
	@Autowired
	StaffsFamilyRepo staffsFamilyRepo;
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody StaffsFamily staffsFamily) {
		try {
		
		StaffsFamily savedStaffFamily=staffsFamilyRepo.save(staffsFamily);
		
		if(savedStaffFamily!=null) {
			return new ResponseEntity<Messages>(HttpResponses.created(savedStaffFamily), HttpStatus.CREATED);
		}
		
		}
		catch (Exception e) {
			System.out.println(e);
		}
			return new ResponseEntity<Messages>(HttpResponses.badrequest(), HttpStatus.BAD_REQUEST);
	}
	

}
