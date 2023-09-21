package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="`Group`")
public class Group {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="group_name", length = 50, nullable = false)
    private String groupName;

    @Column(name="total_member")
    private int totalMember;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="account_id", referencedColumnName = "id")
    private Account creator;

    @Column(name="created_date")
    //@Temporal(TemporalType.TIMESTAMP) default ngày hiện tại
    //@CreationTimestamp
    private Date createdDate;

    public Group() {
    }

    public Group(String groupName, int totalMember, Account creator, Date createdDate) {
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

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
