package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

	private Environment environment;

	@Autowired
	public StudentController(Environment environment) {
		
		this.environment = environment;
	}
	@GetMapping("/")
	public ResponseEntity<String> getStatus()
	{
		return ResponseEntity.ok("student service is up and running on port: "+environment.getProperty("local.server.port"));
	}
}
