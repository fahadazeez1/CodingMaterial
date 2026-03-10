package com.example.Compony.Dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComponyCreateDto {
    @NotBlank(message="name cannot be null")
    private String name;
    @NotBlank(message="location cannot be null")
    private String location;

    @NotNull(message="employees cannot be null")
    @Min(1)
    private Integer employees;
//    private List<Jobs> jobs;

}
/*
{
  "name": "TCS",
  "jobs": [
    {
      "role": "Backend Developer",
      "description": "Develop and maintain Spring Boot microservices.",
      "applicationStartDate": "2026-03-01",
      "applicationEndDate": "2026-04-01",
      "openings": 5
    },
    {
      "role": "Frontend Developer",
      "description": "Build responsive UIs using modern frameworks.",
      "applicationStartDate": "2026-03-05",
      "applicationEndDate": "2026-04-15",
      "openings": 2
    }
  ]
}
 */