package com.eshop.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.eshop.demo.model.User;
import com.eshop.demo.repo.RoleRepo;
import com.eshop.demo.repo.UserRepo;


@Controller
public class HomeController {

    private final RoleRepo roleRepo;
	
		@Autowired
		UserRepo repo;
	
		@Autowired
		PasswordEncoder encoder;

    HomeController(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }
		
		@PostMapping("/adduser")
		public String adduser(@ModelAttribute("user") User user)
		{
			
			user.setPassword(encoder.encode(user.getPassword()));
			repo.save(user);
			return "redirect:reg";
		}
		
		@GetMapping("/admin")
		public String admin()
		{
			return "admin calling";
		}
		
		@GetMapping("/user")
		public String user()
		{
			System.out.println("user calling");
			return "user calling";
		}
}
