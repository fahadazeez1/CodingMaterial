package com.example.revision_4.Service;

import com.example.revision_4.Dtos.DoctorDto;
import com.example.revision_4.Entity.Doctor;
import com.example.revision_4.ExtraStuff.modelmapper;
import com.example.revision_4.Repository.DocRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class Doc_service {
    private final ModelMapper modelMapper;
private  final DocRepo docRepo;
    public List<DoctorDto> alldoctor(){
        List<Doctor> alldocs = docRepo.findAll();
        List<DoctorDto> alldocdtos = alldocs.stream()
                .map(doctor -> modelMapper.map(doctor,DoctorDto.class))
                .collect(Collectors.toList());
       return alldocdtos;
    }
}
