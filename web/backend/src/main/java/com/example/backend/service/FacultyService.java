package com.example.backend.service;

import com.example.backend.dto.FacultyDto;
import java.util.List;

public interface FacultyService {

    List<FacultyDto> getAllFaculties();

    FacultyDto getFacultyById(Long facilityId);

    FacultyDto saveFaculty(FacultyDto facultyDto);

    FacultyDto updateFaculty(FacultyDto facultyDto);

    void deleteFacultyById(Long facilityId);
}
