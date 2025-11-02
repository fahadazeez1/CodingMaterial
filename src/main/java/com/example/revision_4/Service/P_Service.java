package com.example.revision_4.Service;

import com.example.revision_4.Dtos.PatientResponseDto;
import com.example.revision_4.Repository.PetRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

import com.example.revision_4.Entity.Petient;

@Service
@RequiredArgsConstructor
public class P_Service {
    private final ModelMapper modelMapper;
    private final PetRepo petRepo;


    public List<PatientResponseDto> showallpet() {
        List<Petient> petients = petRepo.findAll();
        List<PatientResponseDto> allpets= petients.stream()
                .map(petient -> modelMapper.map(petient, PatientResponseDto.class)) // or .map(petient -> convertToDto(petient))
                .collect(Collectors.toList());
        return allpets;
    }
}
