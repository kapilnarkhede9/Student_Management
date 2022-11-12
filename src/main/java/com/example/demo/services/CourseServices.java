package com.example.demo.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modules.Courses;


public interface CourseServices extends CrudRepository<Courses, Integer> {
	List<Courses> findAllByCourseName(String courseName);
}
