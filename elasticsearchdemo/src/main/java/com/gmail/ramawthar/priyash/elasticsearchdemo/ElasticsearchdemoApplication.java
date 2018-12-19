package com.gmail.ramawthar.priyash.elasticsearchdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;

import com.gmail.ramawthar.priyash.service.BookService;
import java.util.Map;

@SpringBootApplication
public class ElasticsearchdemoApplication implements CommandLineRunner{
	
    @Autowired
    ElasticsearchOperations es;

    @Autowired
    BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchdemoApplication.class, args);

	}
	
	@Override
    public void run(String... args) throws Exception {

		SetupData sd = new SetupData();
		//sd.test(bookService, es);
		sd.test2(bookService, es);
    }

	



}

