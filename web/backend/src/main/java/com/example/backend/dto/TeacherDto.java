package com.example.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeacherDto {

    private Long id;
    @Pattern(regexp = "([A-Za-z]){2,}")
    private String name;
    @Pattern(regexp = "([A-Za-z]){2,}")
    private String surname;
    @Email
    private String email;
    @Pattern(regexp = "^(\\+38)(\\(0\\d{2}\\))(\\d){3}(\\-\\d{2}){2}$")
    private String phone;
}
