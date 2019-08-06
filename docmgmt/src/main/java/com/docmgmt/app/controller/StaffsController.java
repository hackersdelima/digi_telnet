package com.docmgmt.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docmgmt.app.entity.Staffs;
import com.docmgmt.app.message.HttpResponses;
import com.docmgmt.app.message.Messages;
import com.docmgmt.app.repo.StaffsFamilyRepo;
import com.docmgmt.app.repo.StaffsRepo;

@RestController
@RequestMapping("staffs")
public class StaffsController {
	@Autowired
	StaffsRepo staffsRepo;
	@Autowired
	StaffsFamilyRepo staffsFamilyRepo;
	
	@GetMapping(path="/")
	public ResponseEntity<?> read() {
		List<Staffs> list=staffsRepo.findAll();
		
		if(list!=null) {
			if(list.size()>0) {
			return new ResponseEntity<Messages>(HttpResponses.fetched(list), HttpStatus.OK);
			}
			//
			else {
				return new ResponseEntity<Messages>(HttpResponses.notfound(),HttpStatus.NOT_FOUND);
			}
		}
		else {
			return new ResponseEntity<Messages>(HttpResponses.notfound(),HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path="/{id}")
	public ResponseEntity<?> read(@PathVariable int id) {
		try {
			Staffs staff= staffsRepo.findById(id).get();
			
			if (staff!=null) {
				return new ResponseEntity<Staffs>(staff, HttpStatus.ACCEPTED);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<Messages>(HttpResponses.notfound(),HttpStatus.NOT_FOUND);
	}

	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Staffs staffs) {
		try {
		
		Staffs savedStaffs=staffsRepo.save(staffs);
		
		if(savedStaffs!=null) {
			return new ResponseEntity<Messages>(HttpResponses.created(savedStaffs), HttpStatus.CREATED);
		}
		
		}
		catch (Exception e) {
			System.out.println(e);
		}
			return new ResponseEntity<Messages>(HttpResponses.badrequest(), HttpStatus.BAD_REQUEST);
	}
	
//	@PutMapping(path="/{id}")
//	public Staffs update(@PathVariable int id,@RequestBody Staffs staffs) {
//		staffs.setId(id);
//		Staffs updatedStaffs=staffsRepo.save(staffs);
//		return updatedStaffs;
//	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Messages> delete(@PathVariable int id) {
		Staffs staffs=staffsRepo.findById(id).get();

		if(staffs!=null) {
			staffsRepo.deleteById(id);
			return new ResponseEntity<Messages>(HttpResponses.received(), HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<Messages>(HttpResponses.notfound(),HttpStatus.NOT_FOUND);
		}
	}

}





