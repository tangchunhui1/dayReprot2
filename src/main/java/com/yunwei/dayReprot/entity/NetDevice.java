package com.yunwei.dayReprot.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class NetDevice {

    @Id
    private Integer id;

    @DateTimeFormat(pattern = "yyyyMMdd")

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMdd")
    private Date dayDate;
    private String netMachinerName;
    private String ipAdress;
    private Double cpuAverageUsage;
    private Double cpuPeak;
    private Double memoryAverageUsage;
    private Double memoryPeak;
    private String responseTime;


    public Integer getId() {
        /* 26 */
        return this.id;

    }


    public void setId(Integer id) {
        /* 20 */
        this.id = id;
    }


    public Date getDayDate() {
        /* 30 */
        return this.dayDate;

    }

    public void setDayDate(Date dayDate) {
        this.dayDate = dayDate;
    }

    public String getNetMachinerName() {
        /* 32 */
        return this.netMachinerName;

    }

    public void setNetMachinerName(String netMachinerName) {
        this.netMachinerName = netMachinerName;
    }

    public String getIpAdress() {
        /* 34 */
        return this.ipAdress;

    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public Double getCpuAverageUsage() {
        /* 36 */
        return this.cpuAverageUsage;

    }

    public void setCpuAverageUsage(Double cpuAverageUsage) {
        this.cpuAverageUsage = cpuAverageUsage;
    }

    public Double getCpuPeak() {
        /* 38 */
        return this.cpuPeak;

    }

    public void setCpuPeak(Double cpuPeak) {
        this.cpuPeak = cpuPeak;
    }

    public Double getMemoryAverageUsage() {
        /* 40 */
        return this.memoryAverageUsage;

    }

    public void setMemoryAverageUsage(Double memoryAverageUsage) {
        this.memoryAverageUsage = memoryAverageUsage;
    }

    public Double getMemoryPeak() {
        /* 42 */
        return this.memoryPeak;

    }

    public void setMemoryPeak(Double memoryPeak) {
        this.memoryPeak = memoryPeak;
    }

    public String getResponseTime() {
        /* 44 */
        return this.responseTime;

    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

}

