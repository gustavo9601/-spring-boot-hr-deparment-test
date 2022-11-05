package com.springboot.hr.deparment.test.hr.services;

import com.springboot.hr.deparment.test.hr.exceptions.NotFoundException;
import com.springboot.hr.deparment.test.hr.models.dtos.EmployeeIntDto;
import com.springboot.hr.deparment.test.hr.models.dtos.EmployeeOutDto;
import com.springboot.hr.deparment.test.hr.models.entities.Employee;
import com.springboot.hr.deparment.test.hr.models.mappers.EmployeeMapper;
import com.springboot.hr.deparment.test.hr.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;


    public List<EmployeeOutDto> getAllEmployees() {
        List<Employee> employees = this.employeeRepository.findAllEmployeesActiveWithContractActive();
        return this.employeeMapper.mapToDto(employees);
    }

    public EmployeeOutDto createEmployee(EmployeeIntDto employeeIntDto) {
        Employee newEmployee = this.employeeMapper.mapToEntity(employeeIntDto);
        return this.employeeMapper.mapToDto(this.employeeRepository.save(newEmployee));
    }

    public EmployeeOutDto updateEmployee(EmployeeIntDto employeeIntDto, Integer id) {
        Employee employee = this.findOrFailEmployee(id);

        employee.setTaxIdNumber(employeeIntDto.getTaxIdNumber());
        employee.setName(employeeIntDto.getName());
        employee.setLastName(employeeIntDto.getLastName());
        employee.setBirthDate(employeeIntDto.getBirthDate());
        employee.setEmail(employeeIntDto.getEmail());
        employee.setCellPhone(employeeIntDto.getCellPhone());

        return this.employeeMapper.mapToDto(this.employeeRepository.save(employee));
    }

    private Employee findOrFailEmployee(Integer id) {
        return this.employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND.value(), "No se encontro el empleado"));
    }
}
