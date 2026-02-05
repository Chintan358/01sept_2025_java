package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.StudentDao;
import com.model.Student;

@Controller
public class HomeController {
	
	@Autowired
	StudentDao dao;

	@RequestMapping("/")
	public String index(Model model)
	{
		Student st = new Student();
		model.addAttribute("st", st);
		model.addAttribute("students",dao.allstudents());
		return "index";
	}
	
	@PostMapping("/addstudent")
	public String addstudent(@ModelAttribute("st") Student st)
	{
		dao.addorUpdateStudent(st);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("id") int id)
	{
		dao.deleteStudent(id);
		return "redirect:/";
	}
	
	@GetMapping("/edit")
	public String editStduent(@RequestParam("id") int id,Model model)
	{
		Student st = dao.studentbyid(id);
		model.addAttribute("st", st);
		model.addAttribute("students",dao.allstudents());
		return "index";
	}
	

}
