package com.yunwei.dayReport.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class DutyInfo {

    @Id
    private Integer id;

    @DateTimeFormat(pattern = "yyyyMMdd")

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMdd")
    private Date dayDate;
    private String week;
    private String dayShift;
    private String nightShift;

    public Integer getId() {
        /* 26 */
        return this.id;

    }


    public void setId(Integer id) {
        /* 21 */
        this.id = id;
    }


    public Date getDayDate() {
        /* 30 */
        return this.dayDate;

    }

    public void setDayDate(Date dayDate) {
        this.dayDate = dayDate;
    }

    public String getWeek() {
        /* 32 */
        return this.week;

    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDayShift() {
        /* 34 */
        return this.dayShift;

    }

    public void setDayShift(String dayShift) {
        this.dayShift = dayShift;
    }

    public String getNightShift() {
        /* 36 */
        return this.nightShift;

    }

    public void setNightShift(String nightShift) {
        this.nightShift = nightShift;
    }

}
