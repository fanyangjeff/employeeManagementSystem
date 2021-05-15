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

    public String insertEmployee(Employee employee) {
          Optional<Employee> targetEmployee = this.employeeRepoMongoDB.findByEmail(employee.getEmail());
          if (targetEmployee.isPresent()) {
              return "email has been registered";
          }
        UUID newID = UUID.randomUUID();
        employee.setId(newID);
        employeeRepoMongoDB.save(employee);
        return "employee added";
    }

    public Optional<Employee> searchEmployeeById(UUID id) {
          return this.employeeRepoMongoDB.findById(id);
    }

    public Optional<Employee> searchEmployeeByEmail(String email) {
        return this.employeeRepoMongoDB.findByEmail(email);
    }

    public String updateEmployeeByEmail(Employee employee) {
          Optional<Employee> targetEmployee = this.employeeRepoMongoDB.findByEmail(employee.getEmail());
          if (!targetEmployee.isPresent()) {
              return employee.getEmail() + " has not been registered";
          }
          employee.setId(targetEmployee.get().getId());
          this.employeeRepoMongoDB.save(employee);
          return "updated successfully";
    }

    public Optional<Employee> deleteEmployeeById(UUID id) {
          Optional<Employee> targetEmployee= this.employeeRepoMongoDB.findById(id);
          if (!targetEmployee.isPresent()) {
              return null;
          }
          this.employeeRepoMongoDB.deleteById(id);
          return targetEmployee;
    }

    public Optional<Employee> deleteEmployeeByEmail(String email) {
          Optional<Employee> targetEmployee = this.employeeRepoMongoDB.findByEmail(email);
          if (!targetEmployee.isPresent()) {
              return null;
          }
          this.employeeRepoMongoDB.deleteByEmail(email);
          return targetEmployee;
    }
}
