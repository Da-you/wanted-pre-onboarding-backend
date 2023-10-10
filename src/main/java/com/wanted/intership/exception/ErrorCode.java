package com.wanted.intership.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    COMPANY_NOT_FOUND(HttpStatus.NOT_FOUND, "A001", "회사를 찾을 수 없습니다."),
    RECRUITMENT_NOTICE_NOT_FOUND(HttpStatus.BAD_REQUEST,"A002" ,"채용공고의 필수 기재 사항을 확인해주세요" );


    private final HttpStatus status;
    private final String code;
    private final String message;



}
