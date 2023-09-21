package com.vti.controller;
import com.vti.entity.Group;
import com.vti.service.GroupService;
import com.vti.service.IGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping()
    public List<Group> getListGroups () {
        List<Group> groups = groupService.getListGroups();
        return groups;
    }
}
