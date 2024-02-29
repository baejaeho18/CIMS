package com.example.demo.domain;

import static com.example.demo.domain.UserRole.ROLE_USER;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Alias("Member")
public class Member {
    private Long hashcode;
    private String name;
    private String id;
    private String pwd;
    private Boolean valid;
    private UserRole userRole = ROLE_USER;

    public Member() {
    }

    public Member(String name, String id, String pwd) {
        this.name = name;
        this.id = id;
        this.pwd = pwd;
    }

    public Member(String name, String id, String pwd, UserRole userRole) {
        this.name = name;
        this.id = id;
        this.pwd = pwd;
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "member: " + this.id + " " + this.userRole.toString();
    }

    public Long getHashcode() {
        return hashcode;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setHashcode(Long hashcode) {
        this.hashcode = hashcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
