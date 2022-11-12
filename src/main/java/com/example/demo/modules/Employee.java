package com.example.demo.modules;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.annotation.sql.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_id = 0;

	@Column
	private String name;
	@Column(unique =true)
	private String email;
	@Column
	private String password;
	@Column
	private String dob;
	@Column
	private int i_id;
	@Column
	private float salary;
	@Column
	private String branch;

	Employee(Employee e) {
		this.name = e.name;
		this.email = e.email;
		this.password = e.password;
		this.i_id = e.i_id;
		this.salary = e.salary;
		this.branch = e.branch;

	}

	@Override
	public String toString() {
		return "Employee [id=" + emp_id + ", name=" + name + ", email=" + email + ", password=" + password + ", dob="
				+ dob + ", i_id=" + i_id + ", salary=" + salary + ", branch=" + branch + "]";
	}

	public Employee() {

	}

	public Employee(int id, String name, String email, String password, int i_id, float salary, String branch) {
		super();
		this.emp_id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.i_id = i_id;
		this.salary = salary;
		this.branch = branch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getI_id() {
		return i_id;
	}

	public void setI_id(int i_id) {
		this.i_id = i_id;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}
