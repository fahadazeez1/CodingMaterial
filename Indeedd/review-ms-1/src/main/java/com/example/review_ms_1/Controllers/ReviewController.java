package com.example.review_ms_1.Controllers;

import com.example.review_ms_1.Dtos.ReviewCreateDto;
import com.example.review_ms_1.Services.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService service;

    @GetMapping("/all")
    public ResponseEntity<?> getAllreviews(){
            return ResponseEntity.ok(service.getAllReview());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOnereviews(@PathVariable Long id){
            return ResponseEntity.ok(service.getReviewById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createReview(@Valid @RequestBody ReviewCreateDto dto){
            return ResponseEntity.ok(service.createReview(dto));
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<?> getReviewsByCompany(@PathVariable Long id){
            return ResponseEntity.ok(service.getAllReviewsByCompany(id));
    }

    @DeleteMapping("/company/{id}")
    public ResponseEntity<?> deleteAllReviewByCompanyId(@PathVariable Long id){
        return ResponseEntity.ok(service.deletReviewsByCompanyId(id));
    }



}
