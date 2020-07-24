package com.yunwei.dayReport.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;




@Entity
 public class ZdYwZy {

    @Id
     private Integer zyId;

    @DateTimeFormat(pattern = "yyyyMM")

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMM")
     private Date date;
       private String ywType;
       private Integer cpuNum;
       private Integer pcNum;


    public Integer getZyId() {
        /* 26 */
        return this.zyId;

    }



    public void setZyId(Integer zyId) {
        /* 21 */
        this.zyId = zyId;
    }



    public Date getDate() {
        /* 30 */
        return this.date;

    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getYwType() {
        /* 32 */
        return this.ywType;

    }

    public void setYwType(String ywType) {
        this.ywType = ywType;
    }

    public Integer getCpuNum() {
        /* 34 */
        return this.cpuNum;

    }

    public void setCpuNum(Integer cpuNum) {
        this.cpuNum = cpuNum;
    }

    public Integer getPcNum() {
        /* 36 */
        return this.pcNum;

    }

    public void setPcNum(Integer pcNum) {
        this.pcNum = pcNum;
    }

}

