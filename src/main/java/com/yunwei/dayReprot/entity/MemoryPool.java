package com.yunwei.dayReprot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class MemoryPool {

    @Id
    private Integer id;

    @DateTimeFormat(pattern = "yyyyMMdd")

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMdd")
    private Date dayDate;
    private String category;
    private Integer num;
    private String memoryPoolName;
    private Double maxAbleCapacity;
    private Double usedCapacity;
    private Double realMaxAbleCapacity;
    private Double utilizationRate;
    private Double backupsNumber;
    private String selfBuiltOrNot;


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

    public String getCategory() {
        /* 31 */
        return this.category;

    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getNum() {
        /* 33 */
        return this.num;

    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getMemoryPoolName() {
        /* 35 */
        return this.memoryPoolName;

    }

    public void setMemoryPoolName(String memoryPoolName) {
        this.memoryPoolName = memoryPoolName;
    }

    public Double getMaxAbleCapacity() {
        /* 37 */
        return this.maxAbleCapacity;

    }

    public void setMaxAbleCapacity(Double maxAbleCapacity) {
        this.maxAbleCapacity = maxAbleCapacity;
    }

    public Double getUsedCapacity() {
        /* 39 */
        return this.usedCapacity;

    }

    public void setUsedCapacity(Double usedCapacity) {
        this.usedCapacity = usedCapacity;
    }

    public Double getRealMaxAbleCapacity() {
        /* 41 */
        return this.realMaxAbleCapacity;

    }

    public void setRealMaxAbleCapacity(Double realMaxAbleCapacity) {
        this.realMaxAbleCapacity = realMaxAbleCapacity;
    }

    public Double getUtilizationRate() {
        /* 43 */
        return this.utilizationRate;

    }

    public void setUtilizationRate(Double utilizationRate) {
        this.utilizationRate = utilizationRate;
    }

    public Double getBackupsNumber() {
        /* 45 */
        return this.backupsNumber;

    }

    public void setBackupsNumber(Double backupsNumber) {
        this.backupsNumber = backupsNumber;
    }

    public String getSelfBuiltOrNot() {
        /* 47 */
        return this.selfBuiltOrNot;

    }

    public void setSelfBuiltOrNot(String selfBuiltOrNot) {
        this.selfBuiltOrNot = selfBuiltOrNot;
    }

}
