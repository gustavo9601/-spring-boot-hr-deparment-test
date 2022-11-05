package com.springboot.hr.deparment.test.hr.models.mappers;

import com.springboot.hr.deparment.test.hr.models.dtos.EmployeeOutDto;
import com.springboot.hr.deparment.test.hr.models.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mappings({
            @org.mapstruct.Mapping(source = "contract.contractType.name", target = "contractType"),
            @org.mapstruct.Mapping(source = "contract.dateFrom", target = "contractDateFrom"),
            @org.mapstruct.Mapping(source = "contract.dateTo", target = "contractDateTo"),
            @org.mapstruct.Mapping(source = "contract.salaryPerDay", target = "contractSalaryPerDay")
    })
    EmployeeOutDto mapToDto(Employee employee);

    List<EmployeeOutDto> mapToDto(List<Employee> employees);
}
