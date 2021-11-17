package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.School;
import com.example.demo.service.SchoolService;
import com.example.demo.shared.SchoolProxy;
import com.example.demo.shared.StudentDto;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/school")
public class SchoolController {
	
	private SchoolService schoolService;
	private Environment environment;
	private SchoolProxy schoolProxy;
	private Logger logger=LoggerFactory.getLogger(SchoolController.class);
	@Autowired
	public SchoolController(SchoolService schoolService,Environment environment,SchoolProxy schoolProxy) {
	
		this.environment=environment;
		this.schoolProxy=schoolProxy;
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
	@GetMapping("/schools/{schoolName}")
	@CircuitBreaker(name = "circuit-breaker-1",fallbackMethod = "testFallBack")
	public ResponseEntity<List<StudentDto>> findStudentBySchoolName(@PathVariable("schoolName") String schoolName)
	{
		
		return ResponseEntity.ok(schoolProxy.findStudentBySchoolName(schoolName));
	}
	
	 private  ResponseEntity<String> testFallBack(Exception e){
		 logger.error("within testFallBack");
	        return new ResponseEntity<String>("student-service is down. try again", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	

}
