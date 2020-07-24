package com.yunwei.dayReport.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Distribution {

    @Id
    private Integer id;

    @DateTimeFormat(pattern = "yyyyMMdd")

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMdd")
    private Date dayDate;
    private String region;
    private String electrofacies;
    private Double phaseVoltage;


    public Integer getId() {
        /* 25 */
        return this.id;

    }


    /* 20 */
    public void setId(Integer id) {
        this.id = id;
    }


    public Date getDayDate() {
        /* 29 */
        return this.dayDate;

    }

    public void setDayDate(Date dayDate) {
        this.dayDate = dayDate;
    }

    public String getRegion() {
        /* 31 */
        return this.region;

    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getElectrofacies() {
        /* 33 */
        return this.electrofacies;

    }

    public void setElectrofacies(String electrofacies) {
        this.electrofacies = electrofacies;
    }

    public Double getPhaseVoltage() {
        /* 35 */
        return this.phaseVoltage;

    }

    public void setPhaseVoltage(Double phaseVoltage) {
        this.phaseVoltage = phaseVoltage;
    }

}
