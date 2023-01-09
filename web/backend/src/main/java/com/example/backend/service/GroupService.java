package com.example.backend.service;

import com.example.backend.dto.GroupDto;
import java.util.List;

public interface GroupService {

    List<GroupDto> getAllGroups();

    GroupDto getGroupById(Long groupId);

    GroupDto saveGroup(GroupDto groupDto);

    GroupDto updateGroup(GroupDto groupDto);

    void deleteGroupById(Long groupId);
}
