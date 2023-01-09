package com.example.backend.service;

import com.example.backend.dto.TeacherDto;
import java.util.List;

public interface TeacherService {

    List<TeacherDto> getAllTeachers();

    TeacherDto getTeacherById(Long teacherId);

    TeacherDto saveTeacher(TeacherDto teacherDto);

    TeacherDto updateTeacher(TeacherDto teacherDto);

    void deleteTeacherById(Long teacherId);
}
