package com.example.backend.controller;

import com.example.backend.dto.DepartmentDto;
import com.example.backend.service.DepartmentService;
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
@RequestMapping("/departments")
@AllArgsConstructor
@CrossOrigin
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/getAll")
    public List<DepartmentDto> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping("/getById")
    public DepartmentDto getDepartmentById(@RequestBody DepartmentDto departmentDto) {
        return departmentService.getDepartmentById(departmentDto.getId());
    }

    @PostMapping("/save")
    public DepartmentDto saveDepartment(@Validated @RequestBody DepartmentDto departmentDto) {
        return departmentService.saveDepartment(departmentDto);
    }

    @PostMapping("/update")
    public DepartmentDto updateDepartment(@Validated @RequestBody DepartmentDto departmentDto) {
        return departmentService.updateDepartment(departmentDto);
    }

    @PostMapping("/delete")
    public void deleteDepartment(@RequestBody DepartmentDto departmentDto) {
        departmentService.deleteDepartmentById(departmentDto.getId());
    }
}
