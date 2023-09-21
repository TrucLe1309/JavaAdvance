package com.vti.repository;

import com.vti.entity.Group;

import java.util.List;

public interface IGroupRepository {
    void addNewGroup(Group grp);

    List<Group> getListGroups();
}
