package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "student_table")
public class Student {
	@Column(name = "unique_id",unique = true,nullable = false)
	private String studentId;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "student_name")
	String studentName;
	@Column(name = "school_name",nullable = false)
	String schoolName;
	public Student() {
		super();
	}
	public Student(String studentId, String studentName, String schoolName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.schoolName = schoolName;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	

}
