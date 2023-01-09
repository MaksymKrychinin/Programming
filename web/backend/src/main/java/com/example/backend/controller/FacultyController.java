package com.example.backend.controller;

import com.example.backend.dto.FacultyDto;
import com.example.backend.service.FacultyService;
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
@RequestMapping("/facilities")
@AllArgsConstructor
@CrossOrigin
public class FacultyController {

    private final FacultyService facultyService;

    @GetMapping("/getAll")
    public List<FacultyDto> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

    @PostMapping("/getById")
    public FacultyDto getFacultyById(@RequestBody FacultyDto facultyDto) {
        return facultyService.getFacultyById(facultyDto.getId());
    }

    @PostMapping("/save")
    public FacultyDto saveFaculty(@Validated @RequestBody FacultyDto facultyDto) {
        return facultyService.saveFaculty(facultyDto);
    }

    @PostMapping("/update")
    public FacultyDto updateFaculty(@Validated @RequestBody FacultyDto facultyDto) {
        return facultyService.updateFaculty(facultyDto);
    }

    @PostMapping("/delete")
    public void deleteFaculty(@RequestBody FacultyDto facultyDto) {
        facultyService.deleteFacultyById(facultyDto.getId());
    }
}
