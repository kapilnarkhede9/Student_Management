package com.example.demo.controller;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.APIs.ResponseHandler;
import com.example.demo.APIs.ResponseStatus;
import com.example.demo.APIs.StudentAPI;
import com.example.demo.modules.Courses;
import com.example.demo.modules.Students;
import com.example.demo.services.StudentServices;

@RestController
public class studentController {
	@Autowired
	StudentServices services;
	@Autowired
	StudentAPI studentAPI;
	@Autowired
	ResponseHandler responseHandler;
	
	Students students = new Students();

	@RequestMapping("studentLogin")
	ResponseEntity<?> studentLogin(String email,String password) {
		try {
			return ResponseHandler.generateMapResponse("Login Sucessfully",HttpStatus.OK,studentAPI.login(email, password));
		}catch(Exception e) {
			return ResponseHandler.generateMapResponse(e.getMessage(),HttpStatus.BAD_REQUEST,e.getStackTrace()[0]);
		}		 
	}
	
	
	@PostMapping("Student")
	Object addStudent(Students s, String cfmPassword) {
//		ModelAndView mv = new ModelAndView("pages/StudentDashboard.html");	
		try {
			return ResponseHandler.generateMapResponse("Registered Sucessfully",HttpStatus.OK,services.save(studentAPI.Register(s, cfmPassword)));
		} catch (Exception e) {
			return ResponseHandler.generateMapResponse(e.getMessage(),HttpStatus.BAD_REQUEST,e.getStackTrace()[0]);
		}
	}
	
	@PutMapping("Student")
	Students updateStudent(Students s) {	
		return services.save(s);
	}
	
	@DeleteMapping("Student")
	ResponseEntity<?> deleteStudent(Students s) {
		try {
			boolean result = services.existsById(s.getStudent_id());
			services.delete(s);
			return ResponseHandler.generateMapResponse("Deleted Sucessfully",HttpStatus.OK,result && !services.existsById(s.getStudent_id())?"Data Deleted Sucessfully":"Data Not Found");
		} catch (Exception e) {
			return ResponseHandler.generateMapResponse(e.getMessage(),HttpStatus.BAD_REQUEST,e.getStackTrace()[0]);
		}	
	}
	
}

