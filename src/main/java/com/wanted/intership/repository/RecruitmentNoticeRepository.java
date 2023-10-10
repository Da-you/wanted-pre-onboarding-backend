package com.wanted.intership.repository;

import com.wanted.intership.domain.Company;
import com.wanted.intership.domain.RecruitmentNotice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitmentNoticeRepository extends JpaRepository<RecruitmentNotice, Long> {
    RecruitmentNotice findByIdAndCompany(Long noticeId, Company company);
}
