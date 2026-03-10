package com.example.Compony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ComponyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComponyApplication.class, args);
	}

}
