package com.springboot.hr.deparment.test.hr.models.dtos;

import com.springboot.hr.deparment.test.hr.validators.ExistsContracTypetId;
import com.springboot.hr.deparment.test.hr.validators.ExistsEmployeeId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractInDto {

    @NotNull
    @ExistsContracTypetId
    private Integer contractTypeId;
    @NotNull
    @ExistsEmployeeId
    private Integer employeeId;
    @NotNull
    private LocalDate dateFrom;
    @NotNull
    private LocalDate dateTo;
    @NotNull
    @Min(0)
    private Double salaryPerDay;
}
