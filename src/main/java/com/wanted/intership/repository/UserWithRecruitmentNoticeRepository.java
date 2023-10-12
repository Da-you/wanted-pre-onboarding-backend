package com.wanted.intership.repository;

import com.wanted.intership.domain.RecruitmentNotice;
import com.wanted.intership.domain.User;
import com.wanted.intership.domain.UserWithRecruitmentNotice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWithRecruitmentNoticeRepository extends JpaRepository<UserWithRecruitmentNotice, Long> {
    Boolean existsByUserAndRecruitmentNotice(User user, RecruitmentNotice recruitmentNotice);
}
