package com.wanted.intership.domain.dto;

import com.wanted.intership.domain.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeRegisterDto {
    public String position;
    public Integer reward;
    public String content;
    public Skill skill;


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class NoticeUpdateDto{
        public String position;
        public Integer reward;
        public String content;
        public Skill skill;
    }
}
