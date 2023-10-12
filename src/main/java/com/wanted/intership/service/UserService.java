package com.wanted.intership.service;

import com.wanted.intership.domain.Company;
import com.wanted.intership.domain.RecruitmentNotice;
import com.wanted.intership.domain.User;
import com.wanted.intership.domain.UserWithRecruitmentNotice;
import com.wanted.intership.dto.request.ApplyRequest;
import com.wanted.intership.dto.response.RecruitmentNoticeWithCompanyListResponse;
import com.wanted.intership.dto.response.RecruitmentNoticeWithCompanyListResponse.RecruitmentNoticeWithCompanyDetailResponse;
import com.wanted.intership.exception.BusinessException;
import com.wanted.intership.exception.ErrorCode;
import com.wanted.intership.repository.RecruitmentNoticeRepository;
import com.wanted.intership.repository.UserRepository;
import com.wanted.intership.repository.UserWithRecruitmentNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;
    private final RecruitmentNoticeRepository recruitmentNoticeRepo;
    private final UserWithRecruitmentNoticeRepository userWithRecruitmentNoticeRepo;

    @Transactional(readOnly = true)
    public List<RecruitmentNoticeWithCompanyListResponse> getNoticeList() {
        List<RecruitmentNoticeWithCompanyListResponse> res = new ArrayList<>();
        List<RecruitmentNotice> list = recruitmentNoticeRepo.findAll();
        for (RecruitmentNotice recruitmentNotice : list) {
            res.add(RecruitmentNoticeWithCompanyListResponse.builder()
                    .recruitmentNoticeId(recruitmentNotice.getId())
                    .companyName(recruitmentNotice.getCompany().getName())
                    .nation(recruitmentNotice.getCompany().getNation())
                    .location(recruitmentNotice.getCompany().getLocation())
                    .position(recruitmentNotice.getPosition())
                    .reward(recruitmentNotice.getReward())
                    .skill(recruitmentNotice.skillName())
                    .build());
        }
        return res;
    }

    @Transactional(readOnly = true)
    public List<RecruitmentNoticeWithCompanyListResponse> searchNoticeList(String keyword) {
        List<RecruitmentNoticeWithCompanyListResponse> res = new ArrayList<>();
        List<RecruitmentNotice> list = recruitmentNoticeRepo.findByNameContaining(keyword);
        for (RecruitmentNotice recruitmentNotice : list) {
            res.add(RecruitmentNoticeWithCompanyListResponse.builder()
                    .recruitmentNoticeId(recruitmentNotice.getId())
                    .companyName(recruitmentNotice.getCompany().getName())
                    .nation(recruitmentNotice.getCompany().getNation())
                    .location(recruitmentNotice.getCompany().getLocation())
                    .position(recruitmentNotice.getPosition())
                    .reward(recruitmentNotice.getReward())
                    .skill(recruitmentNotice.skillName())
                    .build());
        }
        return res;
    }

    @Transactional(readOnly = true)
    public RecruitmentNoticeWithCompanyDetailResponse noticeDetail(Long noticeId) {
        RecruitmentNotice recruitmentNotice = recruitmentNoticeRepo.findById(noticeId)
                .orElseThrow(() -> new BusinessException(ErrorCode.RECRUITMENT_NOTICE_NOT_FOUND));
        return RecruitmentNoticeWithCompanyDetailResponse.builder()
                .recruitmentNoticeId(recruitmentNotice.getId())
                .companyName(recruitmentNotice.getCompany().getName())
                .nation(recruitmentNotice.getCompany().getNation())
                .location(recruitmentNotice.getCompany().getLocation())
                .position(recruitmentNotice.getPosition())
                .reward(recruitmentNotice.getReward())
                .skill(recruitmentNotice.skillName())
                .content(recruitmentNotice.getContent())
                .additionalNoticeList(getAdditionalNoticeList(noticeId,recruitmentNotice.getCompany()))
                .build();
    }

    @Transactional
    public void applyNotice(ApplyRequest req) {
        User user = userRepo.findById(req.getUserId())
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));
        RecruitmentNotice recruitmentNotice = recruitmentNoticeRepo.getReferenceById(req.getNoticeId());
        Boolean checkApply = userWithRecruitmentNoticeRepo.existsByUserAndRecruitmentNotice(user, recruitmentNotice);
        if (Boolean.TRUE.equals(checkApply)) {
            throw new BusinessException(ErrorCode.ALREADY_APPLY);
        }
        userWithRecruitmentNoticeRepo.save(
                UserWithRecruitmentNotice.apply(
                        user,
                        recruitmentNotice
                )
        );

    }

    private List<Long> getAdditionalNoticeList(Long id,Company company) {
        List<Long> list = recruitmentNoticeRepo.findIdsNotEqual(id,company);
        return list;
    }
}
