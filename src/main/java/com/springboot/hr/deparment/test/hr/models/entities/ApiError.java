package com.springboot.hr.deparment.test.hr.models.entities;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ApiError implements Serializable {
    private static final long serialVersionUID = 1L;

    private String message;
    private Integer code;
    private String status;
    private String description;
    private Map<String, List<String>> errors;
}