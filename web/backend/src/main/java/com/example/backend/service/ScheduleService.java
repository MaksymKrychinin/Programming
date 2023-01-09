package com.example.backend.service;

import com.example.backend.dto.ScheduleDto;
import java.util.List;

public interface ScheduleService {

    List<ScheduleDto> getAllSchedules();

    ScheduleDto getScheduleById(Long scheduleId);

    ScheduleDto saveSchedule(ScheduleDto scheduleDto);

    ScheduleDto updateSchedule(ScheduleDto scheduleDto);

    void deleteScheduleById(Long scheduleId);
}
