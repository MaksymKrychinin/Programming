package com.example.backend.dto;

import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class GroupDto {
    private Long id;
    private Long departmentId;
    @Pattern(regexp = "([A-Za-z0-9])+")
    private String name;
    private Integer course;
}
