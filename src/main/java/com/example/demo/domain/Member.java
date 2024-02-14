package com.example.demo.domain;

public class Member {

    private Long hashcode;
    private String name;
    private String id;
    private String pwd;

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
}
