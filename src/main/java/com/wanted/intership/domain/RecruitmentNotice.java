package com.wanted.intership.domain;

import com.wanted.intership.common.BaseEntity;

import javax.persistence.*;

@Entity
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
    private String nation;
    private String location;

}
