package com.vti.service;

import com.vti.entity.Group;

import java.util.List;

public interface IGroupService{
    void addNewGroup(Group grp);

    List<Group> getListGroups();
}
