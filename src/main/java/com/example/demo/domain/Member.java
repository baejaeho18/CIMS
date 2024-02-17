package com.example.demo.domain;

public class Member {

    private Long hashcode;
    private String name;
    private String id;
    private String pwd;
    private Boolean valid;

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

    public Boolean getValid() { return valid; }

    public void setValid(Boolean valid) { this.valid = valid; }
}
