package com.docmgmt.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("login")
public class LoginController {

	@RequestMapping(value = "/login-page", method = RequestMethod.GET)
	public ModelAndView login(String error, String logout) {
		//calling jsp file
		ModelAndView model=new ModelAndView("login");
		//message to display on login attempt
		String msg="";
		if(error!=null) {
			msg="Invalid Credentials!";
		}
		else if(logout!=null) {
			msg="Logout Successful!";
		}
		model.addObject("msg", msg);
		return model;
	}
	
}
