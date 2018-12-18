package com.gmail.ramawthar.priyash.elasticsearchdemo;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;

import com.gmail.ramawthar.priyash.model.Book;
import com.gmail.ramawthar.priyash.service.BookService;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

public class SetupData {

	private ElasticsearchOperations es;
	
	
	
	public void test(BookService bookService, ElasticsearchOperations es){

        this.es = es;
        printElasticSearchInfo();
        bookService.save(new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017"));
        bookService.save(new Book("1002", "Apache Lucene Basics", "Rambabu Posa", "13-MAR-2017"));
        bookService.save(new Book("1003", "Apache Solr Basics", "Rambabu Posa", "21-MAR-2017"));

        //fuzzey search
        Page<Book> books = bookService.findByAuthor("Rambabu", new PageRequest(0, 10));

        //List<Book> books = bookService.findByTitle("Elasticsearch Basics");

        books.forEach(x -> System.out.println(x));
	}
    //useful for debug, print elastic search details
    private void printElasticSearchInfo() {

        System.out.println("--ElasticSearch--");
        Client client = es.getClient();
        Map<String, Settings> asMap = client.settings().getAsGroups();

        asMap.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
        System.out.println("--ElasticSearch--");
    }
}
