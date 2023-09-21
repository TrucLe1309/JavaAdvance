package com.vti.controller;
import com.vti.dto.GroupDTO;
import com.vti.entity.Group;
import com.vti.service.GroupService;
import com.vti.service.IGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/groups")
public class GroupController {
    private IGroupService groupService;

    public GroupController() {
        groupService = new GroupService();
    }

    @PostMapping()
    public ResponseEntity<?> addNewGroup(@RequestBody Group grp) {
        //...
        System.out.println(grp);
        groupService.addNewGroup(grp);
        return ResponseEntity.status(HttpStatus.OK).body("Add new group successfully");
    }

//    @GetMapping()
//    public List<Group> getListGroups () {
//        List<Group> groups = groupService.getListGroups();
//        return groups;
//    }

    @GetMapping()
    public List<GroupDTO> getListGroups () {
        List<Group> groups = groupService.getListGroups();

        List<GroupDTO> listGrpDTO = new ArrayList<>();

        for (Group group : groups) {
            GroupDTO grpDTO = new GroupDTO(
                    group.getId(),
                    group.getGroupName(),
                    group.getTotalMember(),
                    group.getCreator().getUsername(),
                    group.getCreatedDate()
            );
            listGrpDTO.add(grpDTO);
        }

        return listGrpDTO;
    }
}
