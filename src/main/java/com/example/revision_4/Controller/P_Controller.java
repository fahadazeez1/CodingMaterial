package com.example.revision_4.Controller;

import com.example.revision_4.Dtos.PatientResponseDto;
import com.example.revision_4.Service.P_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class P_Controller {

    private final P_Service pService;

    @GetMapping("/show")
    public List<PatientResponseDto> showallpet(){
        return pService.showallpet();
    }
}
