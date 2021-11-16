package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SchoolDao;
import com.example.demo.model.School;

@Service
public class SchoolServiceImpl implements SchoolService {

	private SchoolDao schoolDao;

	@Autowired
	public SchoolServiceImpl(SchoolDao schoolDao) {

		this.schoolDao = schoolDao;
	}

	@Override
	public School createSchool(School school) {
		// TODO Auto-generated method stub
		return schoolDao.save(school);
	}

	@Override
	public List<School> displayAllSchool() {
		// TODO Auto-generated method stub
		return schoolDao.findAll();
	}

}
