package com.example.employeeservice;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeServiceApplication implements CommandLineRunner {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceApplication(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        employeeRepository.save(new Employee("John","Doe","john@email.com"));
        employeeRepository.save(new Employee("Marry","Public","marry@email.com"));
    }
}
