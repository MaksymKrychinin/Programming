package com.example.backend.service;

import com.example.backend.dto.StudentDto;
import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long studentId);

    StudentDto saveStudent(StudentDto studentDto);

    StudentDto updateStudent(StudentDto studentDto);

    void deleteStudentById(Long studentId);
}
