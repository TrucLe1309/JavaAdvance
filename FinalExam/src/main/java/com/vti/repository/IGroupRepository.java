package com.vti.repository;

import com.vti.entity.Group;
import com.vti.form.FormGroup;

import java.util.List;

public interface IGroupRepository {
    void addNewGroup(Group grp);

    List<Group> getListGroups();

    void addNewGroupWithAccount(FormGroup formGroup);

    void deleteGroups(List<Integer> ids);

    void updateGroup(FormGroup formGroup);

    List<Group> getListGroupsWithSearch(String search);
}
