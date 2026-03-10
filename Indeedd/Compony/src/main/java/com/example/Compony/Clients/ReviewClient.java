package com.example.Compony.Clients;

import com.example.Compony.External.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "REVIEW-MS-1")
public interface ReviewClient {

    @GetMapping("/review/company/{id}")
    List<Review> getReview(@PathVariable  Long id);

    @DeleteMapping("/review/company/{id}")
    int deleteReviewsOfACompany(@PathVariable Long id);


}
