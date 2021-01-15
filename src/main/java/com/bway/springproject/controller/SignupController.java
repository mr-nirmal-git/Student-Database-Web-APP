package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springproject.dao.UserDao;
import com.bway.springproject.model.User;

@Controller
public class SignupController {
	
	@Autowired
	private UserDao udao;
	
	@RequestMapping(value = "/usersignup", method = RequestMethod.GET)
	public String getSignupForm () {
		
		return "signup";
	
	}
	
	@RequestMapping(value="/usersignup", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User u) {
		
		udao.signup(u);
		
		return "login";
		
		
		
	}
	
	
}

