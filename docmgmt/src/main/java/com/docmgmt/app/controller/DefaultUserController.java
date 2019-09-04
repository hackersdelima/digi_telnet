package com.docmgmt.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultUserController {

	@Value("${spring.security.user.name}")
	private String username;
	
	@Value("${spring.security.user.password}")
	private String password;
	
	@RequestMapping("/username")
    public String username() {
        return username;
    }
	
	@RequestMapping("/password")
    public String password() {
        return password;
    }
	
	@RequestMapping("/users")
    public void users() {
		System.out.println("The username is "+username+" "+"password is "+password);
	}
}
