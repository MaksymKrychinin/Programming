package com.example.backend.repository;

import com.example.backend.entity.Department;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

    List<Department> findAll();

    Optional<Department> findById(Long departmentId);

    Department save(Department department);

    void deleteById(Long departmentId);
}
