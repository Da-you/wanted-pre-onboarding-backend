package com.wanted.intership.service;

import com.wanted.intership.domain.Company;
import com.wanted.intership.domain.RecruitmentNotice;
import com.wanted.intership.dto.request.NoticeRegisterDto;
import com.wanted.intership.dto.request.NoticeRegisterDto.NoticeUpdateDto;
import com.wanted.intership.exception.BusinessException;
import com.wanted.intership.exception.ErrorCode;
import com.wanted.intership.repository.CompanyRepository;
import com.wanted.intership.repository.RecruitmentNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RecruitmentNoticeService {
    private final RecruitmentNoticeRepository recruitmentRepo;
    private final CompanyRepository companyRepo;

    @Transactional
    public void registerNotice( NoticeRegisterDto req) {
        Company company = checkExistCompany(req.getCompanyId());
        if (req == null) {
            throw new BusinessException(ErrorCode.RECRUITMENT_NOTICE_NOT_FOUND);
        }

        recruitmentRepo.save(RecruitmentNotice.create(
                        company,
                        req.getPosition(),
                        req.getReward(),
                        req.getContent(),
                        req.getSkill()
                )
        );
    }

    @Transactional
    public void updateNotice( Long noticeId, NoticeUpdateDto req) {
        Company company = checkExistCompany(req.getCompanyId());
        RecruitmentNotice notice = getRecruitmentNotice(noticeId, company);
        notice.update(
                req.getPosition(),
                req.getReward(),
                req.getContent(),
                req.getSkill()
        );
    }

    @Transactional
    public void deleteNotice(Long companyId, Long noticeId) {
        Company company = checkExistCompany(companyId);
        RecruitmentNotice notice = getRecruitmentNotice(noticeId, company);
        notice.delete();
    }


    private Company checkExistCompany(Long companyId) {
        Company company = companyRepo.getReferenceById(companyId);
        if (company == null) {
            throw new BusinessException(ErrorCode.COMPANY_NOT_FOUND);
        }
        return company;
    }

    private RecruitmentNotice getRecruitmentNotice(Long noticeId, Company company) {
        RecruitmentNotice notice = recruitmentRepo.findByIdAndCompany(noticeId, company);
        if (notice == null) {
            throw new BusinessException(ErrorCode.RECRUITMENT_NOTICE_NOT_FOUND);
        }
        return notice;
    }
}
