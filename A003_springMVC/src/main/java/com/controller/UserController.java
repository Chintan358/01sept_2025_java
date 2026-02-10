package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.UserDao;
import com.model.User;

@Controller
public class UserController {
	
		@Autowired
		UserDao dao;
		
		@RequestMapping("/")
		public String index(Model model)
		{
			model.addAttribute("user",new User());
			model.addAttribute("data",dao.all());
			return "index";
		}
		
		@PostMapping("/addUser")
		public String addUser(@ModelAttribute("user") User user)
		{
			dao.addOrUpdateUser(user);
			return "redirect:/";
		}
		
		@GetMapping("/delete")
		public String delete(@RequestParam("id") int id)
		{	
				dao.deleteUser(id);
				return "redirect:/";
		}
		
		@GetMapping("/edit")
		public String edit(@RequestParam("id") int id,Model model)
		{	
			model.addAttribute("user",dao.userById(id));
			model.addAttribute("data",dao.all());
			return "index";
		}
}

