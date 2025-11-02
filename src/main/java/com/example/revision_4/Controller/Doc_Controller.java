package com.example.revision_4.Controller;

import com.example.revision_4.Dtos.DoctorDto;
import com.example.revision_4.Service.Doc_service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class Doc_Controller {
private  final Doc_service docService;

    @GetMapping("/doctors")
    public List<DoctorDto> showalldoctor(){
        return docService.alldoctor();
    }

}
