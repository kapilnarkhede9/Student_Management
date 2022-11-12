package com.example.demo.APIs;

import java.io.IOException;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.modules.Students;
import com.example.demo.services.StudentServices;
import com.fasterxml.jackson.core.sym.Name;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@Service
public class StudentAPI extends BasicValidators {

	@Autowired
	StudentServices studentDao;

	public StudentAPI() {
		super();
	}

	@SuppressWarnings({ "deprecation" })
	public Students login(String email, String password) throws Exception {
		if (verifyEmail(email)) {
			if (studentDao.existsByEmail(email)) {
				if (studentDao.findByEmail(email).getPassword().equals(password)) {
					return studentDao.findByEmail(email);
				} else {
					throw new InvalidInputException("Wrong Password");
				}
			} else {
				throw new InvalidInputException("Email Not Found");
			}
		} 
        else
        {
			throw new InvalidFormatException("Invalid email format", "abc@y.com", null);// InvalidInputException("Invalid)																						// email format");
		}
	}

    public Students Update(Students students,String cfmPassword) throws IOException, InvalidInputException{
        if(!students.equals(null) && studentDao.existsById(students.getStudent_id())) {
			if(!students.getName().equals(null) &&!students.getBranch().equals(null) && !students.getEmail().equals(null) && !cfmPassword.equals(null) && !students.getPassword().equals(null) && (students.getPnr()>0)) {
				if(alaphabetsOnly(students.getName()) && alaphabetsOnly(students.getBranch()) && verifyEmail(students.getEmail()) && PasswordMatcher(cfmPassword, students.getPassword()) && idValidator(students.getPnr()))//check for Invalid format for all details
				{
					if(maxLength(students.getName(), 30) && maxLength(students.getBranch(), 40)) {
						return students;
					}
					else {
						throw new InvalidInputException("Length exception");
					}
				}
				else {
					throw new InvalidInputException("Invalid Format, Please check required data format");
				}
			}else {
				throw new InvalidInputException("Required data cannot be Blank/0/Null");
			}
		}
		else {
			throw new IOException("User not Found!");
		}
    }
	
	public Students Register(Students students,String cfmPassword) throws Exception {
		if(!students.equals(null)) {
			if(!students.getName().equals(null) &&!students.getBranch().equals(null) && !students.getEmail().equals(null) && !cfmPassword.equals(null) && !students.getPassword().equals(null) && (students.getPnr()>0)) {
				if(alaphabetsOnly(students.getName()) && alaphabetsOnly(students.getBranch()) && verifyEmail(students.getEmail()) && PasswordMatcher(cfmPassword, students.getPassword()) && idValidator(students.getPnr()))//check for Invalid format for all details
				{
					if(maxLength(students.getName(), 30) && maxLength(students.getBranch(), 40)) {
						return students;
					}
					else {
						throw new InvalidInputException("Length exception");
					}
				}
				else {
					throw new InvalidInputException("Invalid Format, Please check required data format");
				}
			}else {
				throw new InvalidInputException("Required data cannot be Blank/0/Null");
			}
		}
		else {
			throw new IOException("Server Error!");
		}
	}
}
