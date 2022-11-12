package com.example.demo.modules;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;

@Table
@Entity
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;

	@Column(unique = true)
	private String name;
	
	
	@Column(unique = true)
	private String email;

	@Column
	private String password;

	@Column
	private String gender;

	@Column
	private String dob;

	@Column
	private String branch;

	@Column(unique = true)
	private int pnr;

	@Column
	private int roll_no;

	@Column
	private int status;

	public Students() {

	}

	public Students(Students s){
		this.student_id = s.student_id;
		this.name = s.name;
		this.gender = s.gender;
		this.dob = s.dob;
		this.branch = s.branch;
		this.pnr = s.pnr;
		this.roll_no = s.roll_no;
		this.status = s.status;
		this.password=s.password;
		this.email=s.email;

	}
	
	public Students(int student_id, String name, String gender, String dob, String branch, int pnr, int roll_no,
			int status,String email,String password) {
		super();
		this.student_id = student_id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.branch = branch;
		this.pnr = pnr;
		this.roll_no = roll_no;
		this.status = status;
		this.password=password;
		this.email=email;
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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getPnr() {
		return pnr;
	}

	public void setPnr(int pnr) {
		this.pnr = pnr;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}