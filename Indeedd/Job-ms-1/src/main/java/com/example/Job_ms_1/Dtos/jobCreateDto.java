package com.example.Job_ms_1.Dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class jobCreateDto {
    @NotBlank(message = "role Must be given")
    private String role;
    private String description;
    @NotNull(message = "end date Must be given")
    private LocalDate applicationEndDate;
    @NotNull(message = "start date Must be given")
    private LocalDate applicationStartDate;
    @NotNull(message = "opening must be given")
    @Min(value = 1,message = "opening must be greater then zero")
    private Long openings;
    @NotNull(message = "componyId must be given")
    private Long componyId;
}
