package com.wanted.intership.domain.controller;

import com.wanted.intership.domain.dto.NoticeRegisterDto;
import com.wanted.intership.domain.service.RecruitmentNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.wanted.intership.domain.dto.NoticeRegisterDto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recruitment")
public class RecruitmentNoticeController {
    private final RecruitmentNoticeService recruitmentNoticeService;


    @PostMapping("/register")
    public void registerNotice(Long companyId, @RequestBody NoticeRegisterDto req){
        recruitmentNoticeService.registerNotice(companyId, req);
    }

    @PatchMapping("/{noticeId}/update")
    public void updateNotice(Long companyId,@PathVariable Long noticeId, @RequestBody NoticeUpdateDto req){
        recruitmentNoticeService.updateNotice(companyId,noticeId, req);
    }
    @DeleteMapping("/{noticeId}/delete")
    public void deleteNotice(Long companyId,@PathVariable Long noticeId){
        recruitmentNoticeService.deleteNotice(companyId, noticeId);
    }

}
