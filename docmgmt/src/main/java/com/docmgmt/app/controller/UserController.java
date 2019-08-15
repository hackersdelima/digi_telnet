package com.docmgmt.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.docmgmt.app.entity.Users;
import com.docmgmt.app.message.HttpResponses;
import com.docmgmt.app.message.Messages;
import com.docmgmt.app.repo.StaffsRepo;
import com.docmgmt.app.repo.UsersRepo;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UsersRepo usersRepo;
	
	@Autowired
	StaffsRepo staffsRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping(path="/create-page")
	public ModelAndView createpage() {
		ModelAndView model=new ModelAndView("users/create");
		model.addObject("pagetitle","USERS");
		model.addObject("staffs", staffsRepo.findAll());
		return model;
	}
	
	@GetMapping(path="/view-page")
	public ModelAndView viewpage() {
		ModelAndView model=new ModelAndView("users/view");
		model.addObject("pagetitle","USERS");
		return model;
	}
	
	@GetMapping(path="/")
	public ResponseEntity<?> read(){
		List<Users> list = usersRepo.findAll();
		
		if(list!=null) {
			if(list.size()>0) {
				return new ResponseEntity<Messages>(HttpResponses.fetched(list), HttpStatus.OK);
				}
				else {
					return new ResponseEntity<Messages>(HttpResponses.notfound(),HttpStatus.NOT_FOUND);
				}		}
		else {
			return new ResponseEntity<Messages>(HttpResponses.notfound(),HttpStatus.NOT_FOUND);
		}
	}
	

	@GetMapping(path="/{username}")
	public ResponseEntity<?> read(@PathVariable String username){
		try {
			Users users = usersRepo.findByUsername(username);
			
			if(users!=null){
				return new ResponseEntity<Users>(users, HttpStatus.ACCEPTED);
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<Messages>(HttpResponses.notfound(),HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<Messages> create(@RequestBody Users users) {
		try{
			String password=users.getPassword();
			String confirmpassword=users.getConfirmpassword();
			
			Users savedUsers=null;
			
			if(password.equals(confirmpassword)) {
				savedUsers=new Users();
			String encpassword=passwordEncoder.encode(password);
			users.setPassword(encpassword);
			users=usersRepo.save(users);
			}
		
			if(savedUsers!=null) {
				return new ResponseEntity<Messages>(HttpResponses.created(savedUsers), HttpStatus.CREATED);
			}
		}
		catch (Exception e) {
		}
		return new ResponseEntity<Messages>(HttpResponses.badrequest(), HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Messages> delete(@PathVariable int id) {
		Users users=usersRepo.findById(id).get();

		if(users!=null) {
			usersRepo.deleteById(id);
			return new ResponseEntity<Messages>(HttpResponses.received(), HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<Messages>(HttpResponses.notfound(),HttpStatus.NOT_FOUND);
		}
	}
}
