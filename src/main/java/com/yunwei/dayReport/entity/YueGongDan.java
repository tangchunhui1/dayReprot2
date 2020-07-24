package com.yunwei.dayReport.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class YueGongDan {

    @Id
    private Integer id;

    @DateTimeFormat(pattern = "yyyyMM")

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMM")
    private Date date;
    private String gdType;
    private int gdNum;


    public Integer getId() {
        /* 25 */
        return this.id;

    }


    /* 19 */
    public void setId(Integer id) {
        this.id = id;
    }


    public Date getDate() {
        /* 29 */
        return this.date;

    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGdType() {
        /* 31 */
        return this.gdType;

    }

    public void setGdType(String gdType) {
        this.gdType = gdType;
    }

    public int getGdNum() {
        /* 33 */
        return this.gdNum;

    }

    public void setGdNum(int gdNum) {
        this.gdNum = gdNum;
    }

}

