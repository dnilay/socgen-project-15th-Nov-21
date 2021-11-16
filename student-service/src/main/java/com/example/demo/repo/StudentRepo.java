package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
	@Query
	public List<Student> findByStudentId(String studentId);
	@Query
	public List<Student> findBySchoolName(String schoolName);
	

}
