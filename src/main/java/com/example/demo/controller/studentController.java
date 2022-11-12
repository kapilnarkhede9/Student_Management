package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.modules.Students;
import com.example.demo.services.StudentServices;

@Controller
public class studentController {
	@Autowired
	StudentServices services;
	
	@RequestMapping("students")
	ModelAndView studentList() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",StudentServices.getList());
		mv.setViewName("student.jsp");
		return mv;
	}
	
}
