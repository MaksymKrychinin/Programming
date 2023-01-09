package com.example.backend.mapper;

import com.example.backend.dto.GroupDto;
import com.example.backend.entity.Group;
import com.example.backend.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GroupMapper {

    private final DepartmentRepository departmentRepository;

    public GroupDto groupToDto(Group group) {
        GroupDto groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setName(group.getName());
        groupDto.setCourse(group.getCourse());
        groupDto.setDepartmentId(group.getDepartment().getId());
        return groupDto;
    }

    public Group dtoToGroup(GroupDto groupDto) {
        Group group = new Group();
        group.setId(groupDto.getId());
        group.setName(groupDto.getName());
        group.setCourse(groupDto.getCourse());
        group.setDepartment(departmentRepository.findById(groupDto.getDepartmentId()).get());
        return group;
    }
}
