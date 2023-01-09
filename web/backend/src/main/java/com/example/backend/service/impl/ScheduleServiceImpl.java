package com.example.backend.service.impl;

import com.example.backend.dto.ScheduleDto;
import com.example.backend.mapper.ScheduleMapper;
import com.example.backend.repository.ScheduleRepository;
import com.example.backend.service.ScheduleService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;

    public List<ScheduleDto> getAllSchedules() {
        return scheduleRepository.findAll().stream()
            .map(scheduleMapper::scheduleToDto).collect(
                Collectors.toList());
    }

    public ScheduleDto getScheduleById(Long scheduleId) {
        return scheduleMapper.scheduleToDto(scheduleRepository.findById(scheduleId).get());
    }

    public ScheduleDto saveSchedule(ScheduleDto scheduleDto) {
        return scheduleMapper.scheduleToDto(
            scheduleRepository.save(scheduleMapper.dtoToSchedule(scheduleDto)));
    }

    public ScheduleDto updateSchedule(ScheduleDto scheduleDto) {
        return scheduleMapper.scheduleToDto(
            scheduleRepository.save(scheduleMapper.dtoToSchedule(scheduleDto)));
    }

    public void deleteScheduleById(Long scheduleId) {
        scheduleRepository.deleteById(scheduleId);
    }
}
