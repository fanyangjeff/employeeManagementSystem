package com.employeeManagement.demo.service;

import com.employeeManagement.demo.dao.EmployeeRepoMongoDB;
import com.employeeManagement.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service(value = "employeeService")
public class EmployeeService {

      private EmployeeRepoMongoDB employeeRepoMongoDB;
      @Autowired
      public EmployeeService(@Qualifier("employeeRepoMongoDB") EmployeeRepoMongoDB employeeRepoMongoDB){
          this.employeeRepoMongoDB = employeeRepoMongoDB;
      }


    public List<Employee> getAll() {
        return employeeRepoMongoDB.findAll();
    }

    public Employee insertEmployee(Employee employee) {
          Optional<Employee> targetEmployee = this.employeeRepoMongoDB.findByEmail(employee.getEmail());
          if (targetEmployee != null) {
              return null;
          }
        UUID newID = UUID.randomUUID();
        employee.setId(newID);
        return employeeRepoMongoDB.save(employee);
    }

    public Optional<Employee> searchEmployeeById(UUID id) {
          return this.employeeRepoMongoDB.findById(id);
    }

    public Optional<Employee> searchEmployeeByEmail(String email) {
        return this.employeeRepoMongoDB.findByEmail(email);
    }

    public Optional<Employee> updateEmployeeByEmail(String email) {
          Optional<Employee> targetEmployee = this.employeeRepoMongoDB.findByEmail(email);
          if (targetEmployee == null) {

          }

          return null;
    }
}
