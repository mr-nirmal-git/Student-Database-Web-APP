package com.bway.springproject.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springproject.HomeController;
import com.bway.springproject.dao.EmployeeDao;
import com.bway.springproject.dao.UserDao;
import com.bway.springproject.model.User;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
		@Autowired
		private UserDao udao;
		
		@Autowired
		private EmployeeDao edao;
	
		@RequestMapping(value = "/userlogin", method = RequestMethod.GET)
		public String getloginform() {
			
			logger.info("Loading Login Form");
			
			return "login";
		}
		
		@RequestMapping(value = "/userlogin", method=RequestMethod.POST)
		public String loginUser(@ModelAttribute User u, Model model, HttpSession session, HttpServletRequest req) throws IOException {
			
			
		String input = req.getParameter("g-recaptcha-response");
		boolean res = VerifyRecaptcha.verify(input);
		
	//	if (res) {
			
		 	if (udao.login(u.getUsername(), u.getPassword())) {
				
				logger.info("Login Success");
				session.setAttribute("activeUser", u.getUsername());
				session.setMaxInactiveInterval(5 * 60);
				
				model.addAttribute("user", u.getUsername());
				model.addAttribute("elist", edao.getAll());

				return "home";
			
				}
		// 	else 	{
		
		 			logger.info("Login Failed");
					model.addAttribute("error", "invalid user!!!");
					
			        return "login";
			
			
			//	}
		//
		//		}
		
//	model.addAttribute("error", "You are not human!");
			
	//        return "login";
		
	}
			
			
			
		
		@RequestMapping(value = "/logout", method=RequestMethod.GET)
		public String logout(HttpSession session) {
			
			logger.info("User Log-out");;
			session.invalidate();
			
			return "login";
		}
		
		
}