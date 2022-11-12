package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.APIs.ResponseHandler;
import com.example.demo.modules.Courses;
import com.example.demo.services.CourseServices;

@Controller
public class CoursesController {
	@Autowired
	CourseServices repositryCourseServices;
	
	@RequestMapping("courses")
	ModelAndView Courses() {
		ModelAndView mv = new ModelAndView("pages/LoginRegisterStudents.html");
		return mv;
	}
	
	@PostMapping("courses")
	ResponseEntity<?> addCourse(Courses c){
		try {
			return ResponseHandler.generateMapResponse("Registered Sucessfully",HttpStatus.OK,repositryCourseServices.save(c));
		} catch (Exception e) {
			return ResponseHandler.generateMapResponse(e.getMessage(),HttpStatus.BAD_REQUEST,e.getStackTrace()[0]);
		}
	}
	
	@ResponseBody
	@GetMapping("courses")
	ResponseEntity<Object> getCourse(int id){
		try {
			return ResponseHandler.generateMapResponse("Data Fetched Sucessfully",HttpStatus.OK,repositryCourseServices.findById(id));
		} catch (Exception e) {
			return ResponseHandler.generateMapResponse(e.getMessage(),HttpStatus.BAD_REQUEST,e.getStackTrace()[0]);
		}
	}
	
	@ResponseBody
	@GetMapping("coursesList")
	ResponseEntity<Object> getCourse(String courseName){
		try {
			return ResponseHandler.generateMapResponse("Data Fetched Sucessfully",HttpStatus.OK,repositryCourseServices.findAllByCourseName(courseName));
		} catch (Exception e) {
			return ResponseHandler.generateMapResponse(e.getMessage(),HttpStatus.BAD_REQUEST,e.getStackTrace()[0]);
		}
	}
	
	@ResponseBody
	@PutMapping("courses")
	Courses updateCourse(Courses c){
			return repositryCourseServices.save(c);
	}
	
	@ResponseBody
	@DeleteMapping("courses")
	ResponseEntity<Object> deleteCourse(Courses c) {
		try {
			boolean result = repositryCourseServices.existsById(c.getId());
			repositryCourseServices.delete(c);;
			return ResponseHandler.generateMapResponse("Deleted Sucessfully",HttpStatus.OK,result && !repositryCourseServices.existsById(c.getId())?"Data Deleted Sucessfully":"Data Not Found");
		} catch (Exception e) {
			return ResponseHandler.generateMapResponse(e.getMessage(),HttpStatus.BAD_REQUEST,e.getStackTrace()[0]);
		}
		
	}
}
