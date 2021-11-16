package com.example.demo.service;

import java.util.List;

import com.example.demo.model.School;

public interface SchoolService {
	
	public School createSchool(School school);
	public List<School> displayAllSchool();

}
