package com.example.revision_4.Dtos;

import com.example.revision_4.ExtraStuff.GenderType;
import lombok.Data;

@Data
public class PatientResponseDto {
    private Integer tokennumber;
    private String petientname;
    private Integer petientage;
    private GenderType gender;
}