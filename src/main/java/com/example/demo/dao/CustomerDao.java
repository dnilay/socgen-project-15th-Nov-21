package com.example.demo.dao;

import com.example.demo.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends MongoRepository<Customer,String> {
}
