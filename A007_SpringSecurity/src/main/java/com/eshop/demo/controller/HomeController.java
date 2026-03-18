package com.eshop.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
		@GetMapping("/user")
		public String index()
		{
			return "index";
		}
		
		@GetMapping("/admin")
		public String admin()
		{
			return "Admin";
		}
		
		@GetMapping("/login")
		public String login()
		{
			return "login";
		}
		
		@GetMapping("/fail")
		public String fail()
		{
			return "fail";
		}
		
		@GetMapping("/home")
		public String home()
		{
			return "home";
		}
		
		@GetMapping("/logout")
		public String logout()
		{
			return "logout";
		}
}
