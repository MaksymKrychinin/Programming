package com.example.backend.service;

import com.example.backend.dto.DepartmentDto;
import java.util.List;

public interface DepartmentService {

    List<DepartmentDto> getAllDepartments();

    DepartmentDto getDepartmentById(Long departmentId);

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto updateDepartment(DepartmentDto departmentDto);

    void deleteDepartmentById(Long departmentId);
}
