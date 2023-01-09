package com.example.backend.service.impl;

import com.example.backend.dto.StudentDto;
import com.example.backend.mapper.StudentMapper;
import com.example.backend.repository.StudentRepository;
import com.example.backend.service.StudentService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream()
            .map(studentMapper::studentToDto).collect(
                Collectors.toList());
    }

    public StudentDto getStudentById(Long studentId) {
        return studentMapper.studentToDto(studentRepository.findById(studentId).get());
    }

    public StudentDto saveStudent(StudentDto studentDto) {
        return studentMapper.studentToDto(
            studentRepository.save(studentMapper.dtoToStudent(studentDto)));
    }

    public StudentDto updateStudent(StudentDto studentDto) {
        return studentMapper.studentToDto(
            studentRepository.save(studentMapper.dtoToStudent(studentDto)));
    }

    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
