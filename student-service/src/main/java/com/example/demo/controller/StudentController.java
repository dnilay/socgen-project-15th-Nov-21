package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.converter.StudentConverter;
import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	private Environment environment;
	private StudentService studentService;
	private StudentConverter studentConverter;

	public StudentController(Environment environment, StudentService studentService,
			StudentConverter studentConverter) {

		this.environment = environment;
		this.studentService = studentService;
		this.studentConverter = studentConverter;
	}

	@GetMapping("/")
	public ResponseEntity<String> getStatus() {
		return ResponseEntity
				.ok("student service is up and running on port: " + environment.getProperty("local.server.port"));
	}

	@PostMapping("/students")
	public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto)

	{
		studentDto.setStudentId(UUID.randomUUID().toString());
		Student student = studentConverter.studentDtoToStudunt(studentDto);
		Student tempStudent=studentService.createStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(studentConverter.studentToStudentDto(tempStudent));
	}
	@GetMapping("/students/{schoolName}")
	public List<StudentDto> listStudentsBySchoolName(@PathVariable("schoolName") String schoolName)
	{
		List<Student> list=studentService.displayStudentBySchoolName(schoolName);
		List<StudentDto> list2=new ArrayList<StudentDto>();
		Iterator<Student> iterator=list.iterator();
		while(iterator.hasNext())
		{
			list2.add(studentConverter.studentToStudentDto(iterator.next()));
		}
		
		return list2;
		
		
	}

}
