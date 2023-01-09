package com.example.backend.repository;

import com.example.backend.entity.Discipline;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepository extends CrudRepository<Discipline, Long> {
    List<Discipline> findAll();

    Optional<Discipline> findById(Long disciplineId);

    Discipline save(Discipline discipline);
    void deleteById(Long disciplineId);
}
