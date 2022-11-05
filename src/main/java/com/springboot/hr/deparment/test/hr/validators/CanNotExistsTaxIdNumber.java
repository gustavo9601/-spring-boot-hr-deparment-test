package com.springboot.hr.deparment.test.hr.validators;

import com.springboot.hr.deparment.test.hr.validators.implementation.CanNotExistsTaxIdNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CanNotExistsTaxIdNumberValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface CanNotExistsTaxIdNumber {

    String message() default "El TaxIdNumber ya existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
