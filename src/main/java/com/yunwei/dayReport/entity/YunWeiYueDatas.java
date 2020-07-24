package com.yunwei.dayReport.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class YunWeiYueDatas {

    @Id
    private Integer id;

    @DateTimeFormat(pattern = "dd")

    @JsonFormat(timezone = "GMT+8", pattern = "dd")
    private Date date;
    private Double zwyflow;
    private Double hlwyflow;
    private Double junwen;
    private Double junshi;
    private Double ups;
    private Double dongli;
    private Double zdianliang;
    private Double cpujun;
    private Double cpufen;
    private Integer zwycpunum;
    private Double zwyneicunnum;
    private Double zwycipannum;
    private Integer hlwycpunum;
    private Double hlwyneicunnum;
    private Double hlwycipannum;
    private Double gongxiangcpu;
    private Double xietongcpu;
    private Double jiyuecpu;
    private Double yidiancpu;
    private Double rexiancpu;


    public Integer getId() {
        /* 24 */
        return this.id;

    }


    /* 19 */
    public void setId(Integer id) {
        this.id = id;
    }


    public Date getDate() {
        /* 28 */
        return this.date;

    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getZwyflow() {
        /* 30 */
        return this.zwyflow;

    }

    public void setZwyflow(Double zwyflow) {
        this.zwyflow = zwyflow;
    }

    public Double getHlwyflow() {
        /* 32 */
        return this.hlwyflow;

    }

    public void setHlwyflow(Double hlwyflow) {
        this.hlwyflow = hlwyflow;
    }

    public Double getJunwen() {
        /* 34 */
        return this.junwen;

    }

    public void setJunwen(Double junwen) {
        this.junwen = junwen;
    }

    public Double getJunshi() {
        /* 36 */
        return this.junshi;

    }

    public void setJunshi(Double junshi) {
        this.junshi = junshi;
    }

    public Double getUps() {
        /* 38 */
        return this.ups;

    }

    public void setUps(Double ups) {
        this.ups = ups;
    }

    public Double getDongli() {
        /* 40 */
        return this.dongli;

    }

    public void setDongli(Double dongli) {
        this.dongli = dongli;
    }

    public Double getZdianliang() {
        /* 42 */
        return this.zdianliang;

    }

    public void setZdianliang(Double zdianliang) {
        this.zdianliang = zdianliang;
    }

    public Double getCpujun() {
        /* 44 */
        return this.cpujun;

    }

    public void setCpujun(Double cpujun) {
        this.cpujun = cpujun;
    }

    public Double getCpufen() {
        /* 46 */
        return this.cpufen;

    }

    public void setCpufen(Double cpufen) {
        this.cpufen = cpufen;
    }

    public Integer getZwycpunum() {
        /* 48 */
        return this.zwycpunum;

    }

    public void setZwycpunum(Integer zwycpunum) {
        this.zwycpunum = zwycpunum;
    }

    public Double getZwyneicunnum() {
        /* 50 */
        return this.zwyneicunnum;

    }

    public void setZwyneicunnum(Double zwyneicunnum) {
        this.zwyneicunnum = zwyneicunnum;
    }

    public Double getZwycipannum() {
        /* 52 */
        return this.zwycipannum;

    }

    public void setZwycipannum(Double zwycipannum) {
        this.zwycipannum = zwycipannum;
    }

    public Integer getHlwycpunum() {
        /* 54 */
        return this.hlwycpunum;

    }

    public void setHlwycpunum(Integer hlwycpunum) {
        this.hlwycpunum = hlwycpunum;
    }

    public Double getHlwyneicunnum() {
        /* 56 */
        return this.hlwyneicunnum;

    }

    public void setHlwyneicunnum(Double hlwyneicunnum) {
        this.hlwyneicunnum = hlwyneicunnum;
    }

    public Double getHlwycipannum() {
        /* 58 */
        return this.hlwycipannum;

    }

    public void setHlwycipannum(Double hlwycipannum) {
        this.hlwycipannum = hlwycipannum;
    }

    public Double getGongxiangcpu() {
        /* 60 */
        return this.gongxiangcpu;

    }

    public void setGongxiangcpu(Double gongxiangcpu) {
        this.gongxiangcpu = gongxiangcpu;
    }

    public Double getXietongcpu() {
        /* 62 */
        return this.xietongcpu;

    }

    public void setXietongcpu(Double xietongcpu) {
        this.xietongcpu = xietongcpu;
    }

    public Double getJiyuecpu() {
        /* 64 */
        return this.jiyuecpu;

    }

    public void setJiyuecpu(Double jiyuecpu) {
        this.jiyuecpu = jiyuecpu;
    }

    public Double getYidiancpu() {
        /* 66 */
        return this.yidiancpu;

    }

    public void setYidiancpu(Double yidiancpu) {
        this.yidiancpu = yidiancpu;
    }

    public Double getRexiancpu() {
        /* 68 */
        return this.rexiancpu;

    }

    public void setRexiancpu(Double rexiancpu) {
        this.rexiancpu = rexiancpu;
    }

}

