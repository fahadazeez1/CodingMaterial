package com.example.review_ms_1.Services;

import com.example.review_ms_1.Clients.CompanyClient;
import com.example.review_ms_1.Dtos.ReviewCreateDto;
import com.example.review_ms_1.Entities.Review;
import com.example.review_ms_1.Repositories.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepo repo;
    private final CompanyClient companyClient;

    public List<Review> getAllReview(){
        return repo.findAll();
    }
    public Review getReviewById(Long id){
        return repo.findById(id).orElseThrow(()-> new RuntimeException("Not Found with ID :"+id));
    }
    @Transactional
    public Review createReview(ReviewCreateDto dto){
        if(dto==null) throw  new ResponseStatusException(HttpStatusCode.valueOf(400),"Body must be given");
        companyClient.getCompany(dto.getComponyId());
        Review review = new Review();
        review.setComponyId(dto.getComponyId());
        review.setTitle(dto.getTitle());
        review.setRating(dto.getRating());
        review.setDescription(dto.getDescription());
        return repo.save(review);

    }

    public List<Review> getAllReviewsByCompany(Long CompId){

        return repo.findAllByComponyId(CompId);
    }

    @Transactional
    public int deletReviewsByCompanyId(Long id) {
        try{
           return repo.deleteByComponyId(id);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Something Went Wrong");
        }

    }
}
