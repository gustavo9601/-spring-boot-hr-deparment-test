package com.springboot.hr.deparment.test.hr.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundException extends RuntimeException {

    private Integer code;
    private String message;

}
