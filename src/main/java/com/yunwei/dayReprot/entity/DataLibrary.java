package com.yunwei.dayReprot.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class DataLibrary {

    @Id
    private Integer id;

    @DateTimeFormat(pattern = "yyyyMMdd")

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMdd")
    private Date dayDate;
    private String user;
    private String project;
    private String instanceName;
    private String instanceStatus;
    private Integer maximumSessions;
    private Integer currentSessionsNumber;
    private Double archiveSpaceUsage;


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

    public String getUser() {
        /* 32 */
        return this.user;

    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getProject() {
        /* 34 */
        return this.project;

    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getInstanceName() {
        /* 36 */
        return this.instanceName;

    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getInstanceStatus() {
        /* 38 */
        return this.instanceStatus;

    }

    public void setInstanceStatus(String instanceStatus) {
        this.instanceStatus = instanceStatus;
    }

    public Integer getMaximumSessions() {
        /* 40 */
        return this.maximumSessions;

    }

    public void setMaximumSessions(Integer maximumSessions) {
        this.maximumSessions = maximumSessions;
    }

    public Integer getCurrentSessionsNumber() {
        /* 42 */
        return this.currentSessionsNumber;

    }

    public void setCurrentSessionsNumber(Integer currentSessionsNumber) {
        this.currentSessionsNumber = currentSessionsNumber;
    }

    public Double getArchiveSpaceUsage() {
        /* 44 */
        return this.archiveSpaceUsage;

    }

    public void setArchiveSpaceUsage(Double archiveSpaceUsage) {
        this.archiveSpaceUsage = archiveSpaceUsage;
    }

}

