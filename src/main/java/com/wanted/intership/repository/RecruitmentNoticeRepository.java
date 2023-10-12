package com.wanted.intership.repository;

import com.wanted.intership.domain.Company;
import com.wanted.intership.domain.RecruitmentNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecruitmentNoticeRepository extends JpaRepository<RecruitmentNotice, Long> {
    RecruitmentNotice findByIdAndCompany(Long noticeId, Company company);

    @Query(value = "SELECT * FROM recruitment_notice " +
            "WHERE name LIKE %:keyword%" +
            "OR position LIKE %:keyword%" +
            "OR skill LIKE %:keyword%",
            nativeQuery = true)
    List<RecruitmentNotice> findByNameContaining(@Param("keyword") String keyword);
    @Query(value = "SELECT  company_id FROM recruitment_notice WHERE  company_id != :company_id", nativeQuery = true)
    List<RecruitmentNotice> findAllByCompany(Company company);
}
