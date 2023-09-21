package com.vti.controller;
import com.vti.dto.GroupDTO;
import com.vti.entity.Group;
import com.vti.form.FormGroup;
import com.vti.service.GroupService;
import com.vti.service.IGroupService;
import org.json.JSONException;
import org.json.JSONObject;
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

//    @PostMapping()
//    public ResponseEntity<?> addNewGroup(@RequestBody Group grp) {
//        //...
//        System.out.println(grp);
//        groupService.addNewGroup(grp);
//        return ResponseEntity.status(HttpStatus.OK).body("Add new group successfully");
//    }

    @PostMapping()
    public ResponseEntity<?> addNewGroupWithAccount(@RequestBody FormGroup formGroup) throws JSONException {
        //...
        System.out.println(formGroup);
        groupService.addNewGroupWithAccount(formGroup);
        JSONObject message = new JSONObject();
        message.put("rusultText", "Group inserted successfully");
        message.put("status", 200);

        return ResponseEntity.status(HttpStatus.OK).body(message.toString());
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
                    group.getCreator().getId(),
                    group.getCreatedDate()
            );
            listGrpDTO.add(grpDTO);
        }

        return listGrpDTO;
    }

    @GetMapping("/{search}")
    public List<GroupDTO> getListGroupsWithSearch (@PathVariable(name="search") String search) {
        List<Group> groups = groupService.getListGroupsWithSearch(search);

        List<GroupDTO> listGrpDTO = new ArrayList<>();

        for (int i = 0; i < groups.size(); i ++) {
            GroupDTO grpDTO = new GroupDTO(
                    groups.get(i).getId(),
                    groups.get(i).getGroupName(),
                    groups.get(i).getTotalMember(),
                    groups.get(i).getCreator().getUsername(),
                    groups.get(i).getCreator().getId(),
                    groups.get(i).getCreatedDate());
            listGrpDTO.add(grpDTO);
        }
        return listGrpDTO;
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteGroups(@RequestBody List<Integer> ids) throws JSONException {
        //...
        System.out.println("List group id for deleting: " + ids.toString());
        groupService.deleteGroups(ids);

        JSONObject message = new JSONObject();
        message.put("rusultText", "Group deleted successfully");
        message.put("status", 200);

        return ResponseEntity.status(HttpStatus.OK).body(message.toString());
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateGroup(@PathVariable(name = "id") int id, @RequestBody FormGroup formGroup) throws JSONException {
        //...
        System.out.println("Group's data for updating: " + formGroup);
        System.out.println(formGroup);

        formGroup.setId(id);

        groupService.updateGroup(formGroup);

        JSONObject message = new JSONObject();
        message.put("rusultText", "Group updated successfully");
        message.put("status", 200);

        return ResponseEntity.status(HttpStatus.OK).body(message.toString());
    }

}
