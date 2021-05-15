package com.employeeManagement.demo.controller;

import com.employeeManagement.demo.model.Employee;
import com.employeeManagement.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(@Qualifier("employeeService") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/insertEmployee")
    public String insertEmployee(@RequestBody Employee employee) {
        return this.employeeService.insertEmployee(employee);
    }

    @GetMapping(value = "/getAll")
    public List<Employee> getAllEmployees() {
        return this.employeeService.getAll();
    }

    @GetMapping(value = "/searchByEmail")
    public Optional<Employee> getEmployeeByEmail(@RequestParam String email) {
        return this.employeeService.searchEmployeeByEmail(email);
    }

    @GetMapping(value = "/searchById")
    public Optional<Employee> getEmployeeById(@RequestParam UUID id) {
        return this.employeeService.searchEmployeeById(id);
    }

    @PutMapping(value = "/updateByEmail")
    public String updateEmployeeByEmail(@RequestBody Employee employee) {
        return this.employeeService.updateEmployeeByEmail(employee);
    }

    @DeleteMapping(value = "/deleteById")
    public Optional<Employee> deleteEmployeeById(@RequestParam UUID id) {
        return this.employeeService.deleteEmployeeById(id);
    }

    @DeleteMapping(value = "/deleteByEmail")
    public Optional<Employee> deleteEmployeeByEmail(@RequestParam String email) {
        return this.employeeService.deleteEmployeeByEmail(email);
    }

}
