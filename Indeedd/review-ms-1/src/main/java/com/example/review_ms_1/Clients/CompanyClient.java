package com.example.review_ms_1.Clients;


import com.example.review_ms_1.external.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPONY-MS-1")
public interface CompanyClient {

    @GetMapping("/compony/{id}")
    Company getCompany(@PathVariable Long id);

}
