package com.example.backend.mapper;

import com.example.backend.dto.DepartmentDto;
import com.example.backend.entity.Department;
import com.example.backend.repository.FacultyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DepartmentMapper {

    private final FacultyRepository facultyRepository;

    public DepartmentDto departmentToDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setName(department.getName());
        departmentDto.setShortName(department.getShortName());
        departmentDto.setFacilityId(department.getFaculty().getId());
        return departmentDto;
    }

    public Department dtoToDepartment(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setId(departmentDto.getId());
        department.setName(departmentDto.getName());
        department.setShortName(departmentDto.getShortName());
        department.setFaculty(facultyRepository.findById(departmentDto.getFacilityId()).get());
        return department;
    }
}
