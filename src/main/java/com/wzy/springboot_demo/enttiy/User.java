package com.wzy.springboot_demo.enttiy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * springboot_demo
 * 用户
 *
 * @author Wang Zhiyuan
 * @date 2018-05-30 17:53
 **/
public class User {
    private int age;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String sex;
    @JsonIgnore
    private String password;
    @JsonProperty("iphoneX")
    private String phone;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
    private Date date;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User(int age, String sex, String password, String phone, Date date) {
        this.age = age;
        this.sex = sex;
        this.password = password;
        this.phone = phone;
        this.date = date;
    }
}
