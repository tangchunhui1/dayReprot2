package com.yunwei.dayReprot.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Servicer {

    @Id
    private Integer id;

    @DateTimeFormat(pattern = "yyyyMMdd")

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMdd")
    private Date dayDate;
    private String servicerName;
    private String ipAdress;
    private Integer cpuNum;
    private Double memorySize;
    private Double cpuAverageUsage;
    private Double cpuPeak;
    private Double memoryAverageUsage;
    private Double memoryPeak;
    private String responseTime;
    private Double rootUsage;


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

    public String getServicerName() {
        /* 31 */
        return this.servicerName;

    }

    public void setServicerName(String servicerName) {
        this.servicerName = servicerName;
    }

    public String getIpAdress() {
        /* 33 */
        return this.ipAdress;

    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public Integer getCpuNum() {
        /* 35 */
        return this.cpuNum;

    }

    public void setCpuNum(Integer cpuNum) {
        this.cpuNum = cpuNum;
    }

    public Double getMemorySize() {
        /* 37 */
        return this.memorySize;

    }

    public void setMemorySize(Double memorySize) {
        this.memorySize = memorySize;
    }

    public Double getCpuAverageUsage() {
        /* 39 */
        return this.cpuAverageUsage;

    }

    public void setCpuAverageUsage(Double cpuAverageUsage) {
        this.cpuAverageUsage = cpuAverageUsage;
    }

    public Double getCpuPeak() {
        /* 41 */
        return this.cpuPeak;

    }

    public void setCpuPeak(Double cpuPeak) {
        this.cpuPeak = cpuPeak;
    }

    public Double getMemoryAverageUsage() {
        /* 43 */
        return this.memoryAverageUsage;

    }

    public void setMemoryAverageUsage(Double memoryAverageUsage) {
        this.memoryAverageUsage = memoryAverageUsage;
    }

    public Double getMemoryPeak() {
        /* 45 */
        return this.memoryPeak;

    }

    public void setMemoryPeak(Double memoryPeak) {
        this.memoryPeak = memoryPeak;
    }

    public String getResponseTime() {
        /* 47 */
        return this.responseTime;

    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public Double getRootUsage() {
        /* 49 */
        return this.rootUsage;

    }

    public void setRootUsage(Double rootUsage) {
        this.rootUsage = rootUsage;
    }

}

