package com.example.backend.service.impl;

import com.example.backend.dto.TeacherDto;
import com.example.backend.mapper.TeacherMapper;
import com.example.backend.repository.TeacherRepository;
import com.example.backend.service.TeacherService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public List<TeacherDto> getAllTeachers() {
        return teacherRepository.findAll().stream()
            .map(teacherMapper::teacherToDto).collect(
                Collectors.toList());
    }

    public TeacherDto getTeacherById(Long teacherId) {
        return teacherMapper.teacherToDto(teacherRepository.findById(teacherId).get());
    }

    public TeacherDto saveTeacher(TeacherDto teacherDto) {
        return teacherMapper.teacherToDto(
            teacherRepository.save(teacherMapper.dtoToTeacher(teacherDto)));
    }

    public TeacherDto updateTeacher(TeacherDto teacherDto) {
        return teacherMapper.teacherToDto(
            teacherRepository.save(teacherMapper.dtoToTeacher(teacherDto)));
    }

    public void deleteTeacherById(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }
}
