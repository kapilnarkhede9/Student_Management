package com.example.demo.modules;

import org.springframework.stereotype.Component;


public class Students extends Persons{
	private String branch;
	private int pnr,student_id,roll_no,status;
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
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
	public Students(String name, String gender, String dOB, int person_id, String branch, int pnr, int student_id,
			int roll_no, int status) {
		super(name, gender, dOB, person_id);
		this.branch = branch;
		this.pnr = pnr;
		this.student_id = student_id;
		this.roll_no = roll_no;
		this.status = status;
	}
	
}
