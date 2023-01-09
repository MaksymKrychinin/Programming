package com.example.backend.mapper;

import com.example.backend.dto.FacultyDto;
import com.example.backend.entity.Faculty;
import org.springframework.stereotype.Component;

@Component
public class FacultyMapper {

    public FacultyDto facilityToDto(Faculty faculty) {
        FacultyDto facultyDto = new FacultyDto();
        facultyDto.setId(faculty.getId());
        facultyDto.setName(faculty.getName());
        facultyDto.setShortName(faculty.getShortName());
        return facultyDto;
    }

    public Faculty dtoToFacility(FacultyDto facultyDto) {
        Faculty faculty = new Faculty();
        faculty.setId(facultyDto.getId());
        faculty.setName(facultyDto.getName());
        faculty.setShortName(facultyDto.getShortName());
        return faculty;
    }

}
