package com.example.demo.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;

@Component
@Qualifier("studentConverter")
public class StudentConverter {
	
	private ModelMapper modelMapper;

	@Autowired
	public StudentConverter(ModelMapper modelMapper) {
		
		this.modelMapper = modelMapper;
	};
	
	public Student studentDtoToStudunt(StudentDto studentDto)
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(studentDto,Student.class);
	}
	
	public StudentDto studentToStudentDto(Student student)
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(student, StudentDto.class);
	}

}
