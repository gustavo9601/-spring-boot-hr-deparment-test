package com.springboot.hr.deparment.test.hr.validators;

import com.springboot.hr.deparment.test.hr.validators.implementation.ExistsEmployeeIdValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ExistsEmployeeIdValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ExistsEmployeeId {

    String message() default "El Empleado no existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
