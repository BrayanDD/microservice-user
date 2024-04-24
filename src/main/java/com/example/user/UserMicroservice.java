package com.example.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//micro


@EnableFeignClients

@SpringBootApplication
public class UserMicroservice {

	public static void main(String[] args) {
		SpringApplication.run(UserMicroservice.class, args);
	}

}
