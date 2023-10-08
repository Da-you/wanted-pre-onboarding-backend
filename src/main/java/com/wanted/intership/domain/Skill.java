package com.wanted.intership.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.GeneratedValue;

@Getter
@AllArgsConstructor
public enum Skill {

    Python("Python"),
    Java("Java"),
    Django("Django"),
    Javascript("Javascript"),
    Spring("Spring"),
    React("React"),
    C("C"),
    ;
    private final String skill;
}
