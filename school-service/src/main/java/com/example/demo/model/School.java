package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "school_table")
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "school_id")
	private Integer schoolId;
	@Column(name = "school_name",unique = true,nullable = false)
	private String schoolName;
	public School() {
		
	}
	
	public School(String schoolName) {
		super();
		this.schoolName = schoolName;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	

}
