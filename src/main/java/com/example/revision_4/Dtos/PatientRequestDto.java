package com.example.revision_4.Dtos;

import com.example.revision_4.ExtraStuff.GenderType;
import lombok.Data;

@Data
public class PatientRequestDto {

    private String petientname;
    private Integer petientage;
    private GenderType gender;
}