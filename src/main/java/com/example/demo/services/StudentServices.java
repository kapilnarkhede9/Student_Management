package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.modules.Students;

@Component
public class StudentServices {
	Students temp;
	static ArrayList<Students> list = new ArrayList<Students>();
	public StudentServices() {
		for(int i=0;i<=10;i++) {
			list.add(new Students("Name "+i,"Male","28-10-1999",i,"Computer",i+100,i+200,i+300,400+i));
		}
	}
	public static ArrayList<Students> getList() {
		return list;
	}
	public static void setList(ArrayList<Students> list) {
		StudentServices.list = list;
	}
	boolean addStudent(Students student){
		if(list.add(student))
			return true;
		else
			return false;
	}
	
	boolean removeUser(Students student) {
		int index=0;
		for (Students students : list) {
			index++;
			if(students.getStudent_id()==student.getStudent_id()) {
				list.remove(index);
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
}
