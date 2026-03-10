package com.example.Compony.Dtos;

import com.example.Compony.Entities.Compony;
import com.example.Compony.External.Review;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetCompanyWithReviewDto {
    private Compony compony;
    private List<Review> reviews;

}
