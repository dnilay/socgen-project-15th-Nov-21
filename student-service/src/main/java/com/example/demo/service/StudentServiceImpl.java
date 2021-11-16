package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;
@Service

public class StudentServiceImpl implements StudentService {

	private StudentRepo studentRepo;
	
	@Autowired
	public StudentServiceImpl(StudentRepo studentRepo) {
	
		this.studentRepo = studentRepo;
	}

	@Override
	public Student createStudent(Student student) {

		return studentRepo.save(student);
	}

	@Override
	public List<Student> displayStudentByStudentId(String studentId) {
		// TODO Auto-generated method stub
		return studentRepo.findByStudentId(studentId);
	}

	@Override
	public List<Student> displayStudentBySchoolName(String schoolName) {
		// TODO Auto-generated method stub
		return studentRepo.findBySchoolName(schoolName);
	}

}
