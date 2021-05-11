package com.employeeManagement.demo.controller;

import com.employeeManagement.demo.model.Employee;
import com.employeeManagement.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(@Qualifier("employeeService") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(value = "/getAll")
    public List<Employee> getAllEmployees() {
        return this.employeeService.getAll();
    }

    @GetMapping(value = "/searchByName/{name}")
    public List<Employee> searchByName(@PathVariable String name) {
        return this.employeeService.searchEmployeesByName(name);
    }

    @PostMapping(value = "/insertEmployee")
    public Employee insertEmployee(@RequestBody Employee employee) {
        this.employeeService.insertEmployee(employee);
        return employee;
    }
}
