package com.docmgmt.app.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.docmgmt.app.repo.AdminRepo;

@Service
public class AdminService {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AdminRepo adminRepo;
	
	
	public String checkPasswordConfirmPassword(String password, String confirmPassword) {
		String encpassword="";
		if(password.equals(confirmPassword)) {
			 encpassword=passwordEncoder.encode(password);
		}
		return encpassword;
	}
	
	public void createDto(Object of, Object to) {
		try {
			BeanUtils.copyProperties(of, to);
			
		}
		catch (Exception e) {
			System.out.println(e);			
		}
	}
	
}
