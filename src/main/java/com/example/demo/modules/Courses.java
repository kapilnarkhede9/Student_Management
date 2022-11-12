package com.example.demo.modules;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ElementCollection
	private List<String> SubjectList;
	@Column(unique = true)
	private String courseName;
	@Column
	private String branch;
	@Column
	private String year;
	@Column
	private int i_id;
	@Column
	private String headOfDepartment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<String> getSubjectList() {
		return SubjectList;
	}

	public void setSubjectList(List<String> subjectList) {
		SubjectList = subjectList;
	}

	public Courses(int id, List<String> subjectList, String course, String branch, String year, int i_id,
			String headOfDepartment) {
		super();
		this.id = id;
		SubjectList = subjectList;
		this.courseName = course;
		this.branch = branch;
		this.year = year;
		this.i_id = i_id;
		this.headOfDepartment = headOfDepartment;
	}

	public Courses(List<String> subjectList, String course, String branch, String year, int i_id,
			String headOfDepartment) {
		super();
		SubjectList = subjectList;
		this.courseName = course;
		this.branch = branch;
		this.year = year;
		this.i_id = i_id;
		this.headOfDepartment = headOfDepartment;
	}

	public String getCourse() {
		return courseName;
	}

	public void setCourse(String course) {
		this.courseName = course;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getI_id() {
		return i_id;
	}

	public void setI_id(int i_id) {
		this.i_id = i_id;
	}

	public String getHeadOfDepartment() {
		return headOfDepartment;
	}

	public void setHeadOfDepartment(String headOfDepartment) {
		this.headOfDepartment = headOfDepartment;
	}

	public Courses() {
		// TODO Auto-generated constructor stub
	}

}
