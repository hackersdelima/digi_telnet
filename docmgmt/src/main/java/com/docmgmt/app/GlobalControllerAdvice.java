package com.docmgmt.app;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.docmgmt.app.entity.Users;
import com.docmgmt.app.repo.UsersRepo;

@ControllerAdvice
public class GlobalControllerAdvice {
	@Autowired
	UsersRepo usersRepo;

	@ModelAttribute(name = "profileimage")
	public String profilepic(Authentication authentication) {
		String profileimage = "";
		if (authentication != null) {
			Users current_user = getCurrentUser(authentication);
			byte[] image_byte = current_user.getStaffs().getPic();
			if (image_byte != null) {
				profileimage = Base64.getEncoder().encodeToString(image_byte);
			}
		}
		return profileimage;
	}

	@ModelAttribute(name = "username")
	public String username(Authentication authentication) {
		String username = "";
		try {
			Users current_user = getCurrentUser(authentication);
			if (current_user != null) {
				username = current_user.getUsername();
			}
		} catch (Exception e) {

		}

		return username;
	}

	public Users getCurrentUser(Authentication authentication) {
		String current_username = authentication.getName();
		Users current_user = usersRepo.findByUsername(current_username);
		return current_user;
	}

}
