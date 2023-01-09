package com.example.backend.controller;

import com.example.backend.dto.GroupDto;
import com.example.backend.service.GroupService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groups")
@AllArgsConstructor
@CrossOrigin
public class GroupController {

    private final GroupService groupService;

    @GetMapping("/getAll")
    public List<GroupDto> getAllGroups() {
        return groupService.getAllGroups();
    }

    @PostMapping("/getById")
    public GroupDto getGroupById(@RequestBody GroupDto groupDto) {
        return groupService.getGroupById(groupDto.getId());
    }

    @PostMapping("/save")
    public GroupDto saveGroup(@Validated @RequestBody GroupDto groupDto) {
        return groupService.saveGroup(groupDto);
    }

    @PostMapping("/update")
    public GroupDto updateGroup(@Validated @RequestBody GroupDto groupDto) {
        return groupService.updateGroup(groupDto);
    }

    @PostMapping("/delete")
    public void deleteGroup(@RequestBody GroupDto groupDto) {
        groupService.deleteGroupById(groupDto.getId());
    }
}
