package com.wanted.intership.controller;

import com.wanted.intership.common.dto.SuccessResponse;
import com.wanted.intership.dto.request.ApplyRequest;
import com.wanted.intership.dto.response.RecruitmentNoticeWithCompanyListResponse;
import com.wanted.intership.dto.response.RecruitmentNoticeWithCompanyListResponse.RecruitmentNoticeWithCompanyDetailResponse;
import com.wanted.intership.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public SuccessResponse<List<RecruitmentNoticeWithCompanyListResponse>> searchNoticeList(@RequestParam(required = false) String keyword) {
        return new SuccessResponse<>(userService.searchNoticeList(keyword));
    }
    @GetMapping("/noticeDetail/{noticeId}")
    public SuccessResponse<RecruitmentNoticeWithCompanyDetailResponse> noticeDetail(@PathVariable Long noticeId) {
        return new SuccessResponse<>(userService.noticeDetail(noticeId));
    }

    @PostMapping("/applyNotice")
    public void applyNotice(@RequestBody ApplyRequest req) {
        userService.applyNotice(req);
    }
}
