package com.springboot.hr.deparment.test.hr.validators;

import com.springboot.hr.deparment.test.hr.validators.implementation.ExistsContractIdValidator;
import com.springboot.hr.deparment.test.hr.validators.implementation.ExistsContractTypeIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ExistsContractTypeIdValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ExistsContracTypetId {

    String message() default "El Tipo de contrato no existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
