package com.example.demo.modules;

import org.springframework.stereotype.Component;


public class Persons {
	private String name,gender,dob;
	private int person_id;
	public Persons(String name, String gender, String dOB, int person_id) {
		super();
		this.name = name;
		this.gender = gender;
		this.dob = dOB;
		this.person_id = person_id;
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
	public String getDOB() {
		return dob;
	}
	public void setDOB(String dOB) {
		this.dob = dOB;
	}
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
}
