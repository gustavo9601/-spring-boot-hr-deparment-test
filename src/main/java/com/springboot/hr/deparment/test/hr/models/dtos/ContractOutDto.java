package com.springboot.hr.deparment.test.hr.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractOutDto {

    private Integer id;
    private Integer contractTypeId;
    private Integer employeeId;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Double salaryPerDay;
    private Boolean isActive;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}
