package com.yunwei.dayReport.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class VirtualMachine {

    @Id
    private Integer id;

    @DateTimeFormat(pattern = "yyyyMMdd")

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMdd")
    private Date dayDate;
    private String category;
    private String entryName;
    private String machineName;
    private String ipAdress;
    private Double cpuAverageUsage;
    private Double cpuPeak;
    private Integer cpuNum;
    private Double memoryAverageUsage;
    private Double memoryPeak;
    private Double memorySize;
    private String responseTime;


    public Integer getId() {
        /* 26 */
        return this.id;

    }


    /* 21 */
    public void setId(Integer id) {
        this.id = id;
    }


    public Date getDayDate() {
        /* 30 */
        return this.dayDate;

    }

    public void setDayDate(Date dayDate) {
        this.dayDate = dayDate;
    }

    public String getCategory() {
        /* 32 */
        return this.category;

    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEntryName() {
        /* 34 */
        return this.entryName;

    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public String getMachineName() {
        /* 36 */
        return this.machineName;

    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getIpAdress() {
        /* 38 */
        return this.ipAdress;

    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public Double getCpuAverageUsage() {
        /* 40 */
        return this.cpuAverageUsage;

    }

    public void setCpuAverageUsage(Double cpuAverageUsage) {
        this.cpuAverageUsage = cpuAverageUsage;
    }

    public Double getCpuPeak() {
        /* 42 */
        return this.cpuPeak;

    }

    public void setCpuPeak(Double cpuPeak) {
        this.cpuPeak = cpuPeak;
    }

    public Integer getCpuNum() {
        /* 44 */
        return this.cpuNum;

    }

    public void setCpuNum(Integer cpuNum) {
        this.cpuNum = cpuNum;
    }

    public Double getMemoryAverageUsage() {
        /* 46 */
        return this.memoryAverageUsage;

    }

    public void setMemoryAverageUsage(Double memoryAverageUsage) {
        this.memoryAverageUsage = memoryAverageUsage;
    }

    public Double getMemoryPeak() {
        /* 48 */
        return this.memoryPeak;

    }

    public void setMemoryPeak(Double memoryPeak) {
        this.memoryPeak = memoryPeak;
    }

    public Double getMemorySize() {
        /* 50 */
        return this.memorySize;

    }

    public void setMemorySize(Double memorySize) {
        this.memorySize = memorySize;
    }

    public String getResponseTime() {
        /* 52 */
        return this.responseTime;

    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

}


