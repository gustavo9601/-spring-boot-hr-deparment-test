package com.springboot.hr.deparment.test.hr.controllers;

import com.springboot.hr.deparment.test.hr.models.entities.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ApiErrorHandlerException {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public final ResponseEntity<ApiError> methodArgumentNotValidException(
            MethodArgumentNotValidException exception
    ) {

        log.info("Error en methodArgumentNotValidException - Mensaje: {}", exception.getMessage());
        log.info("Error en methodArgumentNotValidException - Clase: {}", exception.getClass());

        Map<String, List<String>> errors = new HashMap<>();

        exception.getFieldErrors()
                .forEach(error -> {
                    if (errors.containsKey(error.getField())) {
                        errors.get(error.getField()).add(error.getDefaultMessage());
                    } else {
                        errors.put(error.getField(), List.of(error.getDefaultMessage()));
                    }
                });

        ApiError apiError = ApiError.builder()
                .message(exception.getMessage())
                .description("Alguno de los campos enviados es incorrecto")
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .errors(errors)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

}
