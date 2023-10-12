package com.wanted.intership.repository;

import com.wanted.intership.domain.Company;
import com.wanted.intership.domain.RecruitmentNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecruitmentNoticeRepository extends JpaRepository<RecruitmentNotice, Long> {
    RecruitmentNotice findByIdAndCompany(Long noticeId, Company company);


@Query(value = "SELECT * FROM recruitment " +
        "WHERE deleted_at is null " + // 여기에 공백 추가
        "AND (content LIKE %:keyword% OR position LIKE %:keyword% OR skill LIKE %:keyword%)", // 각 조건을 괄호로 묶고, 각 조건 사이에 OR 연산자 추가
        nativeQuery = true)
    List<RecruitmentNotice> findByNameContaining(@Param("keyword") String keyword);

    @Query(value = "SELECT id FROM recruitment " +
            "WHERE  deleted_at is null " +
            "AND (id != :id AND company_id = :companyId)", nativeQuery = true)
    List<Long> findIdsNotEqual(@Param("id") Long id,@Param("companyId") Company company);
}
