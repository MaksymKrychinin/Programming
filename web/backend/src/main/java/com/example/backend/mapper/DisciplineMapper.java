package com.example.backend.mapper;

import com.example.backend.dto.DisciplineDto;
import com.example.backend.entity.Discipline;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DisciplineMapper {

    public DisciplineDto disciplineToDto(Discipline discipline) {
        DisciplineDto disciplineDto = new DisciplineDto();
        disciplineDto.setId(discipline.getId());
        disciplineDto.setName(discipline.getName());
        return disciplineDto;
    }

    public Discipline dtoToDiscipline(DisciplineDto disciplineDto) {
        Discipline discipline = new Discipline();
        discipline.setId(disciplineDto.getId());
        discipline.setName(disciplineDto.getName());
        return discipline;
    }
}
