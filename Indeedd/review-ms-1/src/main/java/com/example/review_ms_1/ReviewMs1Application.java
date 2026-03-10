package com.example.review_ms_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReviewMs1Application {

	public static void main(String[] args) {
		SpringApplication.run(ReviewMs1Application.class, args);
	}

}
