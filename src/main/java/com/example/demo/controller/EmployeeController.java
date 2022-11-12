package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.APIs.ResponseHandler;
import com.example.demo.modules.Employee;
import com.example.demo.services.EmployeeServices;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeServices empDao;
	
	@RequestMapping("emp")
	ModelAndView loader() {
		ModelAndView mv = new ModelAndView("pages/LoginRegisterEmployee.html");
		return mv;
	}
	
	@ResponseBody
	@PostMapping("Employee")
	ResponseEntity<Object> addEmp(Employee e) {try {
		return ResponseHandler.generateMapResponse("Registered Sucessfully",HttpStatus.OK,empDao.save(e));
	} catch (Exception e1) {
		return ResponseHandler.generateMapResponse(e1.getMessage(),HttpStatus.BAD_REQUEST,e1.getStackTrace()[0]);
	}
	}
	
	@ResponseBody
	@RequestMapping("Employee")
	ResponseEntity<Object> getEmp(@RequestParam String email,@RequestParam String password) {
		try {
			return ResponseHandler.generateMapResponse("Login Sucessfully",HttpStatus.OK,empDao.findByEmail(email));
		}catch(Exception e) {
			return ResponseHandler.generateMapResponse(e.getMessage(),HttpStatus.BAD_REQUEST,e.getStackTrace()[0]);
		}
	}
	
	@ResponseBody
	@PutMapping("updateEmp")
	Employee updateEmp(Employee e) {
		//Employee dbemp = empDao.findById(e.getEmp_id()).get();
		return empDao.save(e);
	}
	
	@ResponseBody
	@DeleteMapping("deleteEmp")
	ResponseEntity<Object> deleteEmp(Employee e) {
		try {
			boolean result = empDao.existsById(e.getEmp_id());
			empDao.delete(e);
			return ResponseHandler.generateMapResponse("Deleted Sucessfully",HttpStatus.OK,result && !empDao.existsById(e.getEmp_id())?"Data Deleted Sucessfully":"Data Not Found");
		} catch (Exception e1) {
			return ResponseHandler.generateMapResponse(e1.getMessage(),HttpStatus.BAD_REQUEST,e1.getStackTrace()[0]);
		}
	}

}
