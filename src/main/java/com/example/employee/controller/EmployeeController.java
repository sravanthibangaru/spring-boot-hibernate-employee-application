package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeJpaService;

// Write your code here
@RestController
public class EmployeeController{
    @Autowired 
    public EmployeeJpaService employeeJpaService;

    @GetMapping("/employees")
    public ArrayList<Employee> getAllEmployees(){
        return employeeJpaService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId")int employeeId){
        return employeeJpaService.getEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeJpaService.addEmployee(employee);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable("employeeId")int employeeId,@RequestBody Employee employee){
        return employeeJpaService.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId")int employeeId){
        employeeJpaService.deleteEmployee(employeeId);
    }
}