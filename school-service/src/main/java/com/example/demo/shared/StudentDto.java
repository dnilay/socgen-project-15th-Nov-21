package com.example.demo.shared;

public class StudentDto {

	private String studentId;
	private String studentName;
	private String schoolName;
	public StudentDto() {
		super();
	}
	public StudentDto(String studentId, String studentName, String schoolName) {
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
