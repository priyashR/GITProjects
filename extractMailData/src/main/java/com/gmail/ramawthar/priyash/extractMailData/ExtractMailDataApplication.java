package com.gmail.ramawthar.priyash.extractMailData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExtractMailDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExtractMailDataApplication.class, args);
	}
}
