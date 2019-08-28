package com.docmgmt.app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	
		@RequestMapping(value = "/login-page", method = RequestMethod.GET)
		public ModelAndView login(String error, String logout, Authentication authentication) {
			ModelAndView model=null;
			try {
				if(authentication.getPrincipal()!=null) {
					model=new ModelAndView("user/create");
				}
				//calling jsp file
				else {
				 model=new ModelAndView("login");
				}
			}
			catch (Exception e) {
				model=new ModelAndView("login");
			}
			
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
		
		@RequestMapping(value = "/create-users", method = RequestMethod.GET)
		public ModelAndView userCreate(Authentication authentication) {
			ModelAndView model=new ModelAndView("user/create");
			model.addObject("pagetitle","USER INFORMATION");
			return model;
		}
		

		@RequestMapping(value = "/phone-book", method = RequestMethod.GET)
		public ModelAndView phonebook(Authentication authentication) {
			ModelAndView model=new ModelAndView("phonebook");
			model.addObject("pagetitle","THE PHONE BOOK");
			return model;
		}
		
//		@RequestMapping(value = "/phone-book2", method = RequestMethod.GET)
//		public ModelAndView phonebook2(Authentication authentication) {
//			ModelAndView model=new ModelAndView("phonebook2");
//			model.addObject("pagetitle","THE PHONE BOOK");
//			return model;
//		}
}
