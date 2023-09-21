package com.vti.service;

import com.vti.entity.Group;
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
}
