package com.example.backend.controller;

import com.example.backend.dto.StudentDto;
import com.example.backend.dto.TeacherDto;
import com.example.backend.service.StudentService;
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
@RequestMapping("/students")
@AllArgsConstructor
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/getAll")
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/getById")
    public StudentDto getStudentById(@RequestBody StudentDto studentDto) {
        return studentService.getStudentById(studentDto.getId());
    }

    @PostMapping("/save")
    public StudentDto saveStudent(@Validated @RequestBody StudentDto studentDto) {
        return studentService.saveStudent(studentDto);
    }

    @PostMapping("/update")
    public StudentDto updateStudent(@Validated @RequestBody StudentDto studentDto) {
        return studentService.updateStudent(studentDto);
    }

    @PostMapping("/delete")
    public void deleteStudent(@RequestBody StudentDto studentDto) {
        studentService.deleteStudentById(studentDto.getId());
    }
}
