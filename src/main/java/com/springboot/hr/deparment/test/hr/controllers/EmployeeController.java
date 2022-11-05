package com.springboot.hr.deparment.test.hr.controllers;

import com.springboot.hr.deparment.test.hr.models.dtos.EmployeeOutDto;
import com.springboot.hr.deparment.test.hr.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeOutDto>> getAllEmployees(){
        return ResponseEntity.ok(this.employeeService.getAllEmployees());
    }

}
