package com.springboot.hr.deparment.test.hr.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "tax_id_number", length = 13, nullable = false, unique = true)
    private String taxIdNumber;


    @Column(name = "name", length = 60, nullable = false)
    private String name;

    @Column(name = "last_name", length = 120, nullable = false)
    private String lastName;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "email", length = 60, nullable = false)
    private String email;


    @Column(name = "cell_phone", length = 20, nullable = false)
    private String cellPhone;

    @Embedded
    private Common common = new Common();

    @OneToOne(mappedBy = "employee")
    private Contract contract;
}
