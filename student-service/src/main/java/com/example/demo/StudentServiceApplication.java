package com.example.demo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;

@SpringBootApplication
@EnableEurekaClient
public class StudentServiceApplication implements CommandLineRunner {

	private StudentRepo studentRepo;
	
	@Autowired
	public StudentServiceApplication(StudentRepo studentRepo) {
		
		this.studentRepo = studentRepo;
	}


	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		studentRepo.save(new Student(UUID.randomUUID().toString(), "John", "School-1"));
		studentRepo.save(new Student(UUID.randomUUID().toString(), "Marry", "School-1"));
		studentRepo.save(new Student(UUID.randomUUID().toString(), "Sachin", "School-2"));
		studentRepo.save(new Student(UUID.randomUUID().toString(), "Rahul", "School-3"));
		
	}

}
