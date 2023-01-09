package com.example.backend.service.impl;

import com.example.backend.dto.FacultyDto;
import com.example.backend.mapper.FacultyMapper;
import com.example.backend.repository.FacultyRepository;
import com.example.backend.service.FacultyService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;
    private final FacultyMapper facultyMapper;

    public List<FacultyDto> getAllFaculties() {
        return facultyRepository.findAll().stream()
            .map(facultyMapper::facilityToDto).collect(
                Collectors.toList());
    }

    public FacultyDto getFacultyById(Long facilityId) {
        return facultyMapper.facilityToDto(facultyRepository.findById(facilityId).get());
    }

    public FacultyDto saveFaculty(FacultyDto facultyDto) {
        return facultyMapper.facilityToDto(
            facultyRepository.save(facultyMapper.dtoToFacility(facultyDto)));
    }

    public FacultyDto updateFaculty(FacultyDto facultyDto) {
        return facultyMapper.facilityToDto(
            facultyRepository.save(facultyMapper.dtoToFacility(facultyDto)));
    }

    public void deleteFacultyById(Long facilityId) {
        facultyRepository.deleteById(facilityId);
    }
}

