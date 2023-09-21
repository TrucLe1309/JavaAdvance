package com.vti.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class GroupDTO {
    private int id;

    private String groupName;

    private int totalMember;

    private String creator;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdDate;

    public GroupDTO() {
    }

    public GroupDTO(int id, String groupName, int totalMember, String creator, Date createdDate) {
        this.id = id;
        this.groupName = groupName;
        this.totalMember = totalMember;
        this.creator = creator;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
