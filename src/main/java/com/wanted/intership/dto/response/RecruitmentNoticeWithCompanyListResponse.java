package com.wanted.intership.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentNoticeWithCompanyListResponse {
    private Long recruitmentNoticeId;
    private String companyName;
    private String nation;
    private String location;
    private String position;
    private Integer reward;
    private String skill;


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecruitmentNoticeWithCompanyDetailResponse{
        private Long recruitmentNoticeId;
        private String companyName;
        private String nation;
        private String location;
        private String position;
        private Integer reward;
        private String skill;
        public String content;
        public List<Long> additionalNoticeList;

    }
}

