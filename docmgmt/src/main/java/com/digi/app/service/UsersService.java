package com.digi.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.digi.app.component.UsersComponent;
import com.digi.app.entity.Users;
import com.digi.app.repo.UsersRepo;

@Service
public class UsersService {
	@Autowired
	UsersComponent usersComponent;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UsersRepo usersRepo;
	

	public ResponseEntity<?> findByCurrentUsersStaffsOffice(String currentUsername){
		List<Users> list=usersComponent.findUsersByCurrentUsersStaffsOffice(currentUsername);
		ResponseEntity<?> responsetype=usersComponent.getReturn(list);
		return responsetype;
	}
	
	public Users changedPwdUsers(Users users) {
		String password=users.getPassword();
		String confirmPassword=users.getConfirmpassword();
		
		String encpassword=checkPasswordConfirmPassword(password, confirmPassword);
		if(encpassword.length()>0) {
		users.setPassword(encpassword);
		users=usersRepo.save(users);
		}
		return users;
	}
	
	public String checkPasswordConfirmPassword(String password, String confirmPassword) {
		String encpassword="";
		if(password.equals(confirmPassword)) {
			 encpassword=passwordEncoder.encode(password);
		}
		return encpassword;
	}
}
