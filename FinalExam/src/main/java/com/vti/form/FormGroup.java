package com.vti.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FormGroup {
    private int id;
    private String groupName;
    private int totalMember;
    private int creatorId;

    private Date createdDate;

    public FormGroup() {
    }

    public FormGroup(String groupName, int totalMember, int creatorId, Date createdDate) {
        this.groupName = groupName;
        this.totalMember = totalMember;
        this.creatorId = creatorId;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getTotalMember() {
        return totalMember;
    }

    public void setTotalMember(int totalMember) {
        this.totalMember = totalMember;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "[id=" + id + "; groupName=" + groupName + "; totalMember=" + totalMember + "; creatorId=" + creatorId + "; createdDate=" + createdDate + "]";
    }
}
