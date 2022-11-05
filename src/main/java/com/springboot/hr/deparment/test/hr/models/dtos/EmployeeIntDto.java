package com.springboot.hr.deparment.test.hr.models.dtos;

import com.springboot.hr.deparment.test.hr.validators.CanNotExistsTaxIdNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@CanNotExistsTaxIdNumber // Global validation
public class EmployeeIntDto {

    @Valid
    private Integer id;

    @NotEmpty
    @Size(min = 1, max = 13)
    private String taxIdNumber;

    @NotEmpty
    @Size(min = 1, max = 60)
    private String name;

    @NotEmpty
    @Size(min = 1, max = 50)
    private String lastName;

    @NotNull
    @PastOrPresent
    private LocalDate birthDate;

    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String cellPhone;
}
