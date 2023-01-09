package com.example.backend.repository;

import com.example.backend.entity.Faculty;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Long> {
    List<Faculty> findAll();

    Optional<Faculty> findById(Long facilityId);

    Faculty save(Faculty faculty);
    void deleteById(Long facilityId);
}
