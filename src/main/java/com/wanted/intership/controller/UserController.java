package com.wanted.intership.controller;

import com.wanted.intership.common.dto.SuccessResponse;
import com.wanted.intership.dto.response.RecruitmentNoticeWithCompanyListResponse;
import com.wanted.intership.dto.response.RecruitmentNoticeWithCompanyListResponse.RecruitmentNoticeWithCompanyDetailResponse;
import com.wanted.intership.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/noticeList")
    public SuccessResponse<List<RecruitmentNoticeWithCompanyListResponse>> getNoticeList() {
        return new SuccessResponse<>(userService.getNoticeList());
    }
    @GetMapping("/searchNoticeList")
    public SuccessResponse<List<RecruitmentNoticeWithCompanyListResponse>> searchNoticeList(String keyword) {
        return new SuccessResponse<>(userService.searchNoticeList(keyword));
    }
    @GetMapping("/noticeDetail/{noticeId}")
    public SuccessResponse<RecruitmentNoticeWithCompanyDetailResponse> noticeDetail(Long noticeId) {
        return new SuccessResponse<>(userService.noticeDetail(noticeId));
    }

    @PostMapping("/applyNotice/{noticeId}")
    public void applyNotice(Long userId,Long noticeId) {
        userService.applyNotice(userId,noticeId);
    }



}
