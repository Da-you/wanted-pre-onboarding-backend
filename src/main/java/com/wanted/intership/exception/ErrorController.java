package com.wanted.intership.exception;

import com.wanted.intership.common.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> businessException(BusinessException e) {
        ErrorCode code = e.getErrorcode();
        log.error("BusinessException : " + code.getMessage());
        return ResponseEntity
                .status(HttpStatus.valueOf(Integer.parseInt(code.getStatus().toString().substring(0, 3))))
                .body(new ErrorResponse(code.getStatus(),code.getCode(),code.getMessage()));
    }


}
