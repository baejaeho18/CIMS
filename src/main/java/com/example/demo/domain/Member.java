package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {

    private Long hashcode;
    private String name;
    private String id;
    private String pwd;
    private Boolean valid;
    private UserRole userRole;
    public Member() {
        this.userRole = UserRole.USER;
    }

    @Override
    public String toString() {
        return name+id+pwd;
    }
}
