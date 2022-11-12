package com.example.demo.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modules.Students;

public interface StudentServices extends CrudRepository<Students, Integer>{
	List<Students> findByName(String name);
	Students findByEmail(String email);
	boolean existsByEmail(String email);
}
