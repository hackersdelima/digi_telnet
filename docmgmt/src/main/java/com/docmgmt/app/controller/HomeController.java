package com.docmgmt.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

	@RequestMapping(value = "/login-page", method = RequestMethod.GET)
	public ModelAndView login(String error, String logout) {
		ModelAndView model=new ModelAndView("login");
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
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView dashboard() {
		ModelAndView model=new ModelAndView("dashboard");
		model.addObject("pagetitle","DASHBOARD");
		return model;
	}
}
