package com.example.Compony.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "JOB-MS-1")
public interface JobClient {

    @DeleteMapping("/job/company/{id}")
    int deleteAllJobsofACompany(@PathVariable Long id);
}
