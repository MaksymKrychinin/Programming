package com.example.backend.service.impl;

import com.example.backend.dto.DisciplineDto;
import com.example.backend.mapper.DisciplineMapper;
import com.example.backend.repository.DisciplineRepository;
import com.example.backend.service.DisciplineService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DisciplineServiceImpl implements DisciplineService {

    private final DisciplineRepository disciplineRepository;
    private final DisciplineMapper disciplineMapper;

    public List<DisciplineDto> getAllDisciplines() {
        return disciplineRepository.findAll().stream()
            .map(disciplineMapper::disciplineToDto).collect(
                Collectors.toList());
    }

    public DisciplineDto getDisciplineById(Long disciplineId) {
        return disciplineMapper.disciplineToDto(disciplineRepository.findById(disciplineId).get());
    }

    public DisciplineDto saveDiscipline(DisciplineDto disciplineDto) {
        return disciplineMapper.disciplineToDto(
            disciplineRepository.save(disciplineMapper.dtoToDiscipline(disciplineDto)));
    }

    public DisciplineDto updateDiscipline(DisciplineDto disciplineDto) {
        return disciplineMapper.disciplineToDto(
            disciplineRepository.save(disciplineMapper.dtoToDiscipline(disciplineDto)));
    }

    public void deleteDisciplineById(Long disciplineId) {
        disciplineRepository.deleteById(disciplineId);
    }
}
