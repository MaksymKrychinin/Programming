package com.example.backend.mapper;

import com.example.backend.dto.ScheduleDto;
import com.example.backend.entity.Schedule;
import com.example.backend.repository.DisciplineRepository;
import com.example.backend.repository.GroupRepository;
import com.example.backend.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ScheduleMapper {

    private final GroupRepository groupRepository;
    private final TeacherRepository teacherRepository;
    private final DisciplineRepository disciplineRepository;

    public ScheduleDto scheduleToDto(Schedule schedule) {
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setId(schedule.getId());
        scheduleDto.setTime(schedule.getTime());
        scheduleDto.setClassroom(schedule.getClassroom());
        scheduleDto.setGroupId(schedule.getGroup().getId());
        scheduleDto.setDisciplineId(schedule.getDiscipline().getId());
        scheduleDto.setTeacherId(schedule.getTeacher().getId());
        return scheduleDto;
    }

    public Schedule dtoToSchedule(ScheduleDto scheduleDto) {
        Schedule schedule = new Schedule();
        schedule.setId(scheduleDto.getId());
        schedule.setTime(scheduleDto.getTime());
        schedule.setClassroom(scheduleDto.getClassroom());
        schedule.setGroup(groupRepository.findById(scheduleDto.getGroupId()).get());
        schedule.setDiscipline(disciplineRepository.findById(scheduleDto.getDisciplineId()).get());
        schedule.setTeacher(teacherRepository.findById(scheduleDto.getTeacherId()).get());
        return schedule;
    }
}
