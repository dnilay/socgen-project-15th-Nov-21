package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.SchoolDao;
import com.example.demo.model.School;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class SchoolServiceApplication implements CommandLineRunner {

	private SchoolDao schoolDao;

	@Autowired
	public SchoolServiceApplication(SchoolDao schoolDao) {

		this.schoolDao = schoolDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(SchoolServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		schoolDao.save(new School("School-1"));
		schoolDao.save(new School("School-2"));
		schoolDao.save(new School("School-3"));
		schoolDao.save(new School("School-4"));
		schoolDao.save(new School("School-5"));
		schoolDao.save(new School("School-6"));
	}

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2);
	}

}
