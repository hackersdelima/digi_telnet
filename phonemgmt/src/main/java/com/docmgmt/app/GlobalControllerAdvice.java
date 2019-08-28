package com.docmgmt.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.docmgmt.app.entity.Admin;
import com.docmgmt.app.repo.AdminRepo;

//for values that can be accessed anywhere
@ControllerAdvice
public class GlobalControllerAdvice {
	@Autowired
	AdminRepo adminRepo;


	@ModelAttribute(name = "username")
	public String username(Authentication authentication) {
		String username = "";
		try {
			Admin current_admin = getCurrentAdmin(authentication);
			if (current_admin != null) {
				username = current_admin.getUsername();
			}
		} catch (Exception e) {

		}

		return username;
	}

	//returns the username of the current user
	public Admin getCurrentAdmin(Authentication authentication) {
		String current_username = authentication.getName();
		Admin current_admin = adminRepo.findByUsername(current_username);
		return current_admin;
	}

}
