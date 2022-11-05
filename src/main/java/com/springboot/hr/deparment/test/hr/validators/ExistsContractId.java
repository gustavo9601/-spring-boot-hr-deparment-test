package com.springboot.hr.deparment.test.hr.validators;

import com.springboot.hr.deparment.test.hr.validators.implementation.ExistsContractIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ExistsContractIdValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ExistsContractId {

    String message() default "El Contrato no existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
