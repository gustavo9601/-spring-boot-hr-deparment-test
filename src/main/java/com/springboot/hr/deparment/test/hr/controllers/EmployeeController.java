package com.springboot.hr.deparment.test.hr.controllers;

import com.springboot.hr.deparment.test.hr.models.dtos.EmployeeIntDto;
import com.springboot.hr.deparment.test.hr.models.dtos.EmployeeOutDto;
import com.springboot.hr.deparment.test.hr.models.entities.Employee;
import com.springboot.hr.deparment.test.hr.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeOutDto>> getAllEmployees() {
        return ResponseEntity.ok(this.employeeService.getAllEmployees());
    }



    @PostMapping
    public ResponseEntity<EmployeeOutDto> saveEmployee(@Valid @RequestBody EmployeeIntDto employeeIntDto) {
        return ResponseEntity.ok(this.employeeService.createEmployee(employeeIntDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeOutDto> updateEmployee(@Valid @RequestBody EmployeeIntDto employeeIntDto,
                                                         @RequestParam Integer id) {
        return ResponseEntity.ok(this.employeeService.updateEmployee(employeeIntDto, id));
    }

    @DeleteMapping("/{id}/contracts")
    public ResponseEntity<EmployeeOutDto> deleteEmployeeContract(@RequestParam Integer id) {
        return ResponseEntity.ok(this.employeeService.deleteEmployeeContract(id));
    }

}
