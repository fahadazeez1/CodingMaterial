package com.example.Job_ms_1.Controllers;

import com.example.Job_ms_1.Dtos.jobCreateDto;
import com.example.Job_ms_1.Entities.Jobs;
import com.example.Job_ms_1.Services.jobService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JobController {
    private  final jobService jobservice;

    @GetMapping("/job/jobs")
    public ResponseEntity<?> getAllJobs(){
        return ResponseEntity.ok().body(jobservice.getAllJobs());
    }

    @PostMapping("/job")
    public ResponseEntity<?> createJob(@Valid @RequestBody jobCreateDto dto){
            return ResponseEntity.ok().body(jobservice.createJob(dto));
    }

    @GetMapping("/job/{id}")
    public Jobs getJobDetail(@PathVariable Long id){
            return jobservice.getJobDetail(id);
    }

    @GetMapping("/job/company/{id}")
    public ResponseEntity<?> getAllJobsOfACompany(@PathVariable Long id){
        return ResponseEntity.ok(jobservice.getAllJobsOfACompany(id));
    }

    @DeleteMapping("/job/{id}")
    public boolean deleteJob(@PathVariable Long id){
            return jobservice.deleteJob(id);
    }

    @DeleteMapping("/job/company/{id}")
    public ResponseEntity<?> deleteALlJobOfACompany(@PathVariable Long id){
        return ResponseEntity.ok(jobservice.deleteJobofACompany(id));
    }

}
