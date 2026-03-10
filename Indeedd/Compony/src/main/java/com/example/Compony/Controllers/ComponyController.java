package com.example.Compony.Controllers;

import com.example.Compony.Dtos.ComponyCreateDto;
import com.example.Compony.Services.ComponyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ComponyController {
    private  final ComponyService service;

    @GetMapping("/compony")
    public ResponseEntity<?> getALlCompony(){

        return ResponseEntity.ok().body(service.getAllCompony());
    }

    @GetMapping("/compony/{id}")
   public ResponseEntity<?> getComById(@PathVariable  Long id){
        return  ResponseEntity.ok().body(service.getById(id));
    }
    @GetMapping("/compony/check/{id}")
    public ResponseEntity<?> getComByIdJustCheck(@PathVariable  Long id){
        return  ResponseEntity.ok().body(service.getById(id));
    }


    @PostMapping("/compony")
    public ResponseEntity<?> createCompony(@Valid @RequestBody ComponyCreateDto dto){
        return ResponseEntity.ok().body(service.createCompony(dto));
    }


    @DeleteMapping("/compony/{id}")
    public ResponseEntity<?> deleteCoompony(@PathVariable Long id){
            return ResponseEntity.ok().body(service.deleteCompony(id));

    }

}
