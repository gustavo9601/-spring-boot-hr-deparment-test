package com.springboot.hr.deparment.test.hr.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeOutDto {
    private Integer id;
    private String taxIdNumber;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String cellPhone;
    private String contractType;
    private LocalDate contractDateFrom;
    private LocalDate contractDateTo;
    private Double contractSalaryPerDay;
}
