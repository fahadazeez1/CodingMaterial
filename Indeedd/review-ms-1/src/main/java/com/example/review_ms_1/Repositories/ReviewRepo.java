package com.example.review_ms_1.Repositories;

import com.example.review_ms_1.Entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review,Long> {

    List<Review> findAllByComponyId(Long componyId);

    @Transactional
    @Modifying
    @Query("DELETE from Review r where r.componyId=:id")
    int deleteByComponyId(Long id);
}
