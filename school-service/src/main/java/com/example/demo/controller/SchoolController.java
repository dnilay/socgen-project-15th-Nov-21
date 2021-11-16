package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.School;
import com.example.demo.service.SchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController {
	
	private SchoolService schoolService;
	private Environment environment;

	@Autowired
	public SchoolController(SchoolService schoolService,Environment environment) {
	
		this.environment=environment;
		this.schoolService = schoolService;
	}
	@PostMapping("/schools")
	public ResponseEntity<School> createSchool(@RequestBody School school)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(schoolService.createSchool(school));
	}
	@GetMapping("/schools")
	public ResponseEntity<List<School>> displayAllSchool()
	{
		return new ResponseEntity<List<School>>(schoolService.displayAllSchool(),HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<String> getStatus()
	{
		return ResponseEntity.ok("school service is up and running on port: "+environment.getProperty("local.server.port"));
	}

}
