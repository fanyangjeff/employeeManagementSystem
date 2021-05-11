package com.employeeManagement.demo.service;

import com.employeeManagement.demo.dao.EmployeeRepoMongoDB;
import com.employeeManagement.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void insertEmployee(Employee employee) {
        employeeRepoMongoDB.save(employee);
    }

    public List<Employee> searchEmployeesByName(String name) {
          return this.employeeRepoMongoDB.findByFirstName(name);
    }
}
