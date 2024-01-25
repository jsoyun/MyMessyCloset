package com.favorite.project.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@Getter
public class ExceptionResponse {
    private HttpStatus status;
    private List<String> exceptions;
    private String message;


}
