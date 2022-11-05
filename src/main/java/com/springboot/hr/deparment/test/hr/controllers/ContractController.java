package com.springboot.hr.deparment.test.hr.controllers;

import com.springboot.hr.deparment.test.hr.models.dtos.ContractInDto;
import com.springboot.hr.deparment.test.hr.models.dtos.ContractOutDto;
import com.springboot.hr.deparment.test.hr.models.dtos.EmployeeOutDto;
import com.springboot.hr.deparment.test.hr.models.entities.Employee;
import com.springboot.hr.deparment.test.hr.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @PostMapping
    public ResponseEntity<ContractOutDto> createContract(@Valid @RequestBody ContractInDto contractInDto) {
        return ResponseEntity.ok(this.contractService.saveContract(contractInDto));
    }
}
