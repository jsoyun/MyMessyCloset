package com.favorite.project.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * status : HTTP 상태코드
 * exceptions : 예외에 대한 세부정보
 * message: 전반적인 예외 설명, 사용자에게 보여줄 메시지
 */

@Builder
@Getter
public class ExceptionResponse {
    private HttpStatus status;
    private List<String> exceptions;
    private String message;


}
