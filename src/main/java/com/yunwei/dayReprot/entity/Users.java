package com.yunwei.dayReprot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Users {

    @Id
    private Integer id;
    private String userName;
    private String passWord;
    private String role;

    @DateTimeFormat(pattern = "yyyyMM")

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMM")
    private Date registerTime;


    public Integer getId() {
        /* 23 */
        return this.id;

    }


    /* 19 */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        /* 25 */
        return this.userName;

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        /* 27 */
        return this.passWord;

    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRole() {
        /* 29 */
        return this.role;

    }

    public void setRole(String role) {
        this.role = role;
    }


    public Date getRegisterTime() {
        /* 33 */
        return this.registerTime;

    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

}
