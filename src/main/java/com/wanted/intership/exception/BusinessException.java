package com.wanted.intership.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BusinessException extends RuntimeException {
    private final ErrorCode errorcode;

    public BusinessException(String message, ErrorCode errorcode) {
        super(errorcode.getMessage());
        this.errorcode = errorcode;
    }


}
