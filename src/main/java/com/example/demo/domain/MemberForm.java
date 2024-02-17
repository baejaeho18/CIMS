package com.example.demo.domain;

public class MemberForm {
    private String name;
    private String id;
    private String pwd;

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
