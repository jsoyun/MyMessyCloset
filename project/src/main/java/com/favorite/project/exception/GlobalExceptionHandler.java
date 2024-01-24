package com.favorite.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> processValidationError(MethodArgumentNotValidException exception) {
        List<String> errorMessages = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach((error) -> {
            String errorMessage = error.getField() + ": " + error.getDefaultMessage();
            errorMessages.add(errorMessage);
        });
        ErrorResponse elementNotFound = ErrorResponse.builder().message("유효한 값이 아닙니다").errors(errorMessages).status(HttpStatus.BAD_REQUEST).build();
        return new ResponseEntity<>(elementNotFound, elementNotFound.getStatus());

    }


    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND) //명시적 선언, 하지만 ErrorResponse의 status세부 설정이 우선권 가진다.
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException exception) {
        ErrorResponse elementNotFound = ErrorResponse.builder().message(exception.getMessage()).errors(Collections.singletonList("Element not found")).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(elementNotFound, elementNotFound.getStatus());

    }


}
