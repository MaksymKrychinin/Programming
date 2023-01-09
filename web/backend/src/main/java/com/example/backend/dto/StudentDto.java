package com.example.backend.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class StudentDto {

    private Long id;
    private Long groupId;
    @Pattern(regexp = "([A-Za-z]){2,}")
    private String name;
    @Email
    private String email;
    @Pattern(regexp = "^(\\+38)(\\(0\\d{2}\\))(\\d){3}(\\-\\d{2}){2}$")
    private String phone;
}
