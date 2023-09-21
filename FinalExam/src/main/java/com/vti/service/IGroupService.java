package com.vti.service;

import com.vti.entity.Group;
import com.vti.form.FormGroup;

import java.util.List;

public interface IGroupService{
    void addNewGroup(Group grp);

    List<Group> getListGroups();

    void addNewGroupWithAccount(FormGroup formGroup);

    void deleteGroups(List<Integer> ids);

    void updateGroup(FormGroup formGroup);

    List<Group> getListGroupsWithSearch(String search);
}
