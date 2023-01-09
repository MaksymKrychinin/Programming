package com.example.backend.dto;

import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class DepartmentDto {
    private Long id;
    private Long facilityId;
    @Pattern(regexp = "([A-Za-z0-9])+")
    private String name;
    @Pattern(regexp = "([A-Za-z0-9])+")
    private String shortName;
}
