package com.wanted.intership.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserWithRecruitmentNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "recruitment_notice_id")
    private RecruitmentNotice recruitmentNotice;

    public static UserWithRecruitmentNotice apply(User user, RecruitmentNotice recruitmentNotice){
        UserWithRecruitmentNotice userWithRecruitmentNotice = new UserWithRecruitmentNotice();
        userWithRecruitmentNotice.user = user;
        userWithRecruitmentNotice.recruitmentNotice = recruitmentNotice;
        return userWithRecruitmentNotice;
    }
}
