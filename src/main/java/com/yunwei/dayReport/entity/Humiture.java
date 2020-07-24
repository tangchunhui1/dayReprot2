package com.yunwei.dayReport.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Humiture {

    @Id
    private Integer id;

    @DateTimeFormat(pattern = "yyyyMMdd")

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMdd")
    private Date dayDate;
    private String region;
    private Double temperature;
    private Double humidity;


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

    public String getRegion() {
        /* 32 */
        return this.region;

    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getTemperature() {
        /* 34 */
        return this.temperature;

    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        /* 36 */
        return this.humidity;

    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

}
