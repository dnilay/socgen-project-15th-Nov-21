package com.example.demo.shared;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "student-service")
public interface SchoolProxy {

	@GetMapping("/student/students/{schoolName}")
	public List<StudentDto> findStudentBySchoolName(@PathVariable("schoolName") String schoolName);

}
