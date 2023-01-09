package com.example.backend.service;

import com.example.backend.dto.DisciplineDto;
import java.util.List;

public interface DisciplineService {

    List<DisciplineDto> getAllDisciplines();

    DisciplineDto getDisciplineById(Long disciplineId);

    DisciplineDto saveDiscipline(DisciplineDto disciplineDto);

    DisciplineDto updateDiscipline(DisciplineDto disciplineDto);

    void deleteDisciplineById(Long disciplineId);
}
