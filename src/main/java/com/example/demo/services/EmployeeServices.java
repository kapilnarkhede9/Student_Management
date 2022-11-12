package com.example.demo.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modules.Employee;

public interface EmployeeServices extends CrudRepository<Employee, Integer> {
List<Employee> findByName(String name);
List<Employee> findByEmail(String email);

}
