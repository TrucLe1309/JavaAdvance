package com.vti.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class GroupDTO {
    private int id;

    private String groupName;

    private int totalMember;

    private String creatorUsername;

    private int creatorId;

    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date createdDate;

    public GroupDTO() {
    }

    public GroupDTO(int id, String groupName, int totalMember, String creatorUsername, int createId, Date createdDate) {
        this.id = id;
        this.groupName = groupName;
        this.totalMember = totalMember;
        this.creatorUsername = creatorUsername;
        this.creatorId = createId;
        this.createdDate = createdDate;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
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

    public String getCreatorUsername() {
        return creatorUsername;
    }

    public void setCreatorUsername(String creatorUsername) {
        this.creatorUsername = creatorUsername;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
