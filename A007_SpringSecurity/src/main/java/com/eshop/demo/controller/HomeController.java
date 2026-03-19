package com.eshop.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.eshop.demo.model.User;
import com.eshop.demo.repo.UserRepo;


@Controller
public class HomeController {
	
		@Autowired
		UserRepo repo;
	
		@Autowired
		PasswordEncoder encoder;
	
		@GetMapping("/user")
		public String index()
		{
			return "index";
		}
		
		@GetMapping("/normal")
		public String normal()
		{
			return "normal";
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
		
		@GetMapping("/reg")
		public String reg(Model model)
		{
			model.addAttribute("user", new User());
			return "registration";
		}
		
		@PostMapping("/adduser")
		public String adduser(@ModelAttribute("user") User user)
		{
			
			user.setPassword(encoder.encode(user.getPassword()));
			repo.save(user);
			return "redirect:reg";
		}
}
