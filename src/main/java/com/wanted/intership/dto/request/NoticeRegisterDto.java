package com.wanted.intership.dto.request;

import com.wanted.intership.domain.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeRegisterDto {
    private Long companyId;
    public String position;
    public Integer reward;
    public String content;
    public Skill skill;


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class NoticeUpdateDto{
        private Long companyId;
        public String position;
        public Integer reward;
        public String content;
        public Skill skill;
    }
}
