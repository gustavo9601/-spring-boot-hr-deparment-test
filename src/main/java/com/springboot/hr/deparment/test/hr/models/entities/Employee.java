package com.springboot.hr.deparment.test.hr.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotNull
    @Size(max = 13)
    @Column(name = "tax_id_number")
    private String taxIdNumber;

    @NotNull
    @Size(max = 60)
    private String name;

    @NotNull
    @Size(max = 120)
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @NotNull
    @Size(max = 60)
    private String email;

    @NotNull
    @Size(max = 20)
    @Column(name = "cell_phone")
    private String cellPhone;

    @Embedded
    private Common common;

    @OneToOne(mappedBy = "employee")
    private Contract contract;
}
