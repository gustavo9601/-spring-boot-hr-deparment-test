package com.springboot.hr.deparment.test.hr.services;

import com.springboot.hr.deparment.test.hr.models.dtos.EmployeeOutDto;
import com.springboot.hr.deparment.test.hr.models.mappers.EmployeeMapper;
import com.springboot.hr.deparment.test.hr.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<EmployeeOutDto> getAllEmployees() {
        return this.employeeMapper.mapToDto(this.employeeRepository.findAllEmployeesActiveWithContractActive());
    }
}
