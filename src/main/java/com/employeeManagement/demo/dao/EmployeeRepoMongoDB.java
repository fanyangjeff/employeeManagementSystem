package com.employeeManagement.demo.dao;

import com.employeeManagement.demo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "employeeRepoMongoDB")
public interface EmployeeRepoMongoDB extends MongoRepository<Employee, String> {
    List<Employee> findByFirstName(String name);
    List<Employee> searchByName(String name);
}
