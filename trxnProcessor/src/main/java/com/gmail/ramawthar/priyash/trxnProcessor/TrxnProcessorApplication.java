package com.gmail.ramawthar.priyash.trxnProcessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.gmail.ramawthar.priyash.rabbit"})
@ComponentScan({"com.gmail.ramawthar.priyash.trxnProcessor"})
public class TrxnProcessorApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(TrxnProcessorApplication.class, args);
	}
}
