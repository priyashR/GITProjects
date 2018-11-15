package com.gmail.ramawthar.priyash.DataIngestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataIngestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataIngestionApplication.class, args);
		FetchEmails fetch = new FetchEmails();
		try{
			fetch.run();
		}catch (Exception e){
			System.out.println(e.getStackTrace());
		}
	}
}
