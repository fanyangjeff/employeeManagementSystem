package com.employeeManagement.demo.dao;

import com.employeeManagement.demo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository(value = "employeeRepoMongoDB")
public interface EmployeeRepoMongoDB extends MongoRepository<Employee, UUID> {
    Optional<Employee> findById(UUID id);
    Optional<Employee> findByEmail(String email);

}
