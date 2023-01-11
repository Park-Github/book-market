package com.naver.idealproduction.bookmarket.domain;

import java.util.List;

@SuppressWarnings("unused")
public class Member {

    public static final int SEX_MALE = 0;
    public static final int SEX_FEMALE = 1;
    public static final int SEX_OTHER = 2;

    private String id;
    private String password;
    private String residence;
    private int sex;
    private List<String> hobbies;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
