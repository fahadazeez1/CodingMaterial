package com.example.review_ms_1.Dtos;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Service;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCreateDto {

    @NotBlank(message = "title must be given")
    private String title;
    @NotBlank(message = "description must be given")
    private String description;
    @NotNull(message = "rating must be given")
    @Min(value=0,message = "should be >1")
    @Max(value=5,message = "should be <=5")
    private Double rating;
    @NotNull(message = "componyId must be given")
    private Long componyId;
}
