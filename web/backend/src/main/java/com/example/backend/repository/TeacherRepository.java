package com.example.backend.repository;

import com.example.backend.entity.Teacher;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher,Long> {
    List<Teacher> findAll();

    Optional<Teacher> findById(Long teacherId);

    Teacher save(Teacher teacher);
    void deleteById(Teacher teacherId);
}
