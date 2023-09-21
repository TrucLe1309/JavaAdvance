package com.vti.service;

import com.vti.entity.Group;
import com.vti.form.FormGroup;
import com.vti.repository.GroupRepository;
import com.vti.repository.IGroupRepository;

import java.util.List;

public class GroupService implements IGroupService{
    private IGroupRepository groupRepository;

    public GroupService() {
        groupRepository = new GroupRepository();
    }

    @Override
    public void addNewGroup(Group grp) {
        groupRepository.addNewGroup(grp);
    }

    @Override
    public List<Group> getListGroups() {
        return groupRepository.getListGroups();
    }

    @Override
    public void addNewGroupWithAccount(FormGroup formGroup) {
        groupRepository.addNewGroupWithAccount(formGroup);
    }

    @Override
    public void deleteGroups(List<Integer> ids) {
        groupRepository.deleteGroups(ids);
    }

    @Override
    public void updateGroup(FormGroup formGroup) {
        groupRepository.updateGroup(formGroup);
    }

    @Override
    public List<Group> getListGroupsWithSearch(String search) {
        return groupRepository.getListGroupsWithSearch(search);
    }
}
