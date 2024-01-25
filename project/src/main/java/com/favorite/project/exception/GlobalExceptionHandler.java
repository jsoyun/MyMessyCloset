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
    public ResponseEntity<ExceptionResponse> processValidationError(MethodArgumentNotValidException exception) {
        List<String> Messages = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach((e) -> {
            String errorMessage = e.getField() + ": " + e.getDefaultMessage();
            Messages.add(errorMessage);
        });
        ExceptionResponse elementNotFound = ExceptionResponse.builder().message("유효한 값이 아닙니다").exceptions(Messages).status(HttpStatus.BAD_REQUEST).build();
        return new ResponseEntity<>(elementNotFound, elementNotFound.getStatus());

    }


    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND) //명시적 선언, 하지만 ErrorResponse의 status세부 설정이 우선권 가진다.
    public ResponseEntity<ExceptionResponse> handleNoSuchElementException(NoSuchElementException exception) {
        ExceptionResponse elementNotFound = ExceptionResponse.builder().message(exception.getMessage()).exceptions(Collections.singletonList("Element not found")).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(elementNotFound, elementNotFound.getStatus());

    }


}
