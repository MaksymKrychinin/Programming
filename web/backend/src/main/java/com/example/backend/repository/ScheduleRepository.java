package com.example.backend.repository;

import com.example.backend.entity.Schedule;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
    List<Schedule> findAll();

    Optional<Schedule> findById(Long scheduleId);
    Schedule save(Schedule schedule);
    void deleteById(Schedule scheduleId);
}
