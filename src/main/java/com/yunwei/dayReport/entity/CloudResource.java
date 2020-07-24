package com.yunwei.dayReport.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class CloudResource {

    @Id
    private Integer id;

    @DateTimeFormat(pattern = "yyyyMMdd")

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMdd")
    private Date dayDate;
    private String category;
    private Double cpuUsage;
    private Double memoryUsage;
    private Double storageUsage;
    private Integer nodeNumber;
    private Integer nodesTotal;
    private Integer virtualMachineTotal;
    private Integer virtualMachineNum;
    private Integer shutDownNum;


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

    public String getCategory() {
        /* 32 */
        return this.category;

    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getCpuUsage() {
        /* 34 */
        return this.cpuUsage;

    }

    public void setCpuUsage(Double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public Double getMemoryUsage() {
        /* 36 */
        return this.memoryUsage;

    }

    public void setMemoryUsage(Double memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public Double getStorageUsage() {
        /* 38 */
        return this.storageUsage;

    }

    public void setStorageUsage(Double storageUsage) {
        this.storageUsage = storageUsage;
    }

    public Integer getNodeNumber() {
        /* 40 */
        return this.nodeNumber;

    }

    public void setNodeNumber(Integer nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public Integer getNodesTotal() {
        /* 42 */
        return this.nodesTotal;

    }

    public void setNodesTotal(Integer nodesTotal) {
        this.nodesTotal = nodesTotal;
    }

    public Integer getVirtualMachineTotal() {
        /* 44 */
        return this.virtualMachineTotal;

    }

    public void setVirtualMachineTotal(Integer virtualMachineTotal) {
        this.virtualMachineTotal = virtualMachineTotal;
    }

    public Integer getVirtualMachineNum() {
        /* 46 */
        return this.virtualMachineNum;

    }

    public void setVirtualMachineNum(Integer virtualMachineNum) {
        this.virtualMachineNum = virtualMachineNum;
    }

    public Integer getShutDownNum() {
        /* 48 */
        return this.shutDownNum;

    }

    public void setShutDownNum(Integer shutDownNum) {
        this.shutDownNum = shutDownNum;
    }

}

