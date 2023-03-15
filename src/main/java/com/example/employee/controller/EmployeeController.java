package com.example.employee.controller;

import org.springframework.web.bind.annotation.*;


import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

import com.example.employee.service.EmployeeH2Service; //service
import com.example.employee.model.Employee; //model


@RestController
public class EmployeeController{

    @Autowired //it recommended to use Service class Instance
    private EmployeeH2Service employeeH2Service;

    @GetMapping("/employees")
    public ArrayList<Employee> getEmployees(){
        return employeeH2Service.getEmployees();
    }
    
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") int employeeId){
        return employeeH2Service.getEmployeeById(employeeId);
    }
    
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeH2Service.addEmployee(employee);
    }
    
    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable("employeeId") int employeeId, @RequestBody Employee employee){
        return employeeH2Service.updateEmployee(employeeId, employee);
    }
    
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") int employeeId){
        employeeH2Service.deleteEmployee(employeeId);
    }
}