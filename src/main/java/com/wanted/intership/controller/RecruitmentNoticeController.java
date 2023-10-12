package com.wanted.intership.controller;

import com.wanted.intership.dto.request.NoticeRegisterDto;
import com.wanted.intership.dto.request.NoticeRegisterDto.NoticeUpdateDto;
import com.wanted.intership.service.RecruitmentNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/recruitment")
public class RecruitmentNoticeController {
    private final RecruitmentNoticeService recruitmentNoticeService;


    @PostMapping("/register")
    public void registerNotice(@RequestBody NoticeRegisterDto req){
        recruitmentNoticeService.registerNotice(req);
    }

    @PatchMapping("/{noticeId}")
    public void updateNotice(@PathVariable Long noticeId, @RequestBody NoticeUpdateDto req){
        recruitmentNoticeService.updateNotice(noticeId, req);
    }
    @DeleteMapping("/{companyId}")
    public void deleteNotice(@PathVariable Long companyId,@RequestParam Long noticeId){
        recruitmentNoticeService.deleteNotice(companyId, noticeId);
    }

}
