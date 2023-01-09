package com.example.backend.controller;

import com.example.backend.dto.ScheduleDto;
import com.example.backend.service.ScheduleService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
@AllArgsConstructor
@CrossOrigin
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/getAll")
    public List<ScheduleDto> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @PostMapping("/getById")
    public ScheduleDto getScheduleById(@RequestBody ScheduleDto scheduleDto) {
        return scheduleService.getScheduleById(scheduleDto.getId());
    }

    @PostMapping("/save")
    public ScheduleDto saveSchedule(@Validated @RequestBody ScheduleDto scheduleDto) {
        return scheduleService.saveSchedule(scheduleDto);
    }

    @PostMapping("/update")
    public ScheduleDto updateSchedule(@Validated @RequestBody ScheduleDto scheduleDto) {
        return scheduleService.updateSchedule(scheduleDto);
    }

    @PostMapping("/delete")
    public void deleteSchedule(@RequestBody ScheduleDto scheduleDto) {
        scheduleService.deleteScheduleById(scheduleDto.getId());
    }
}
