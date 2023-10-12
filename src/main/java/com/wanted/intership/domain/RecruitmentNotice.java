package com.wanted.intership.domain;

import com.wanted.intership.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Where(clause = "deletedAt is null")
@Table(name = "recruitment")
public class RecruitmentNotice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    private String position;
    private Integer reward;
    private String content;
    private Skill skill;
    private LocalDateTime deletedAt;

    public static RecruitmentNotice create(Company company, String position, Integer reward, String content, Skill skill) {
        RecruitmentNotice notice = new RecruitmentNotice();
        notice.company = company;
        notice.position = position;
        notice.reward = reward;
        notice.content = content;
        notice.skill = skill;
        return notice;
    }

    public void update(String position, Integer reward, String content, Skill skill) {
        this.position = position;
        this.reward = reward;
        this.content = content;
        this.skill = skill;
    }
    public void delete(){
        this.deletedAt = LocalDateTime.now();
    }
    public String skillName(){
        return this.skill.getSkill();
    }
}
