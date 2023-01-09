package com.example.backend.dto;

import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ScheduleDto {

    private Long id;
    private Long teacherId;
    private Long disciplineId;
    private Long groupId;
    private String time;
    @Pattern(regexp = "([A-Za-z0-9])+")
    private String classroom;
}
