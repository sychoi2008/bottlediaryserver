package com.example.bottlediary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class BottlediaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BottlediaryApplication.class, args);
	}

}
