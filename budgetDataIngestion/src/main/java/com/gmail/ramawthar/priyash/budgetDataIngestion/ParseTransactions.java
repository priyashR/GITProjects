package com.gmail.ramawthar.priyash.budgetDataIngestion;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class ParseTransactions {
	
	String transactionLine;
	String result;

	public ParseTransactions(String transactionLine) {
		super();
		this.transactionLine = transactionLine;
		this.result = "Awaiting parsing";
	}

	public String getTransactionLine() {
		return transactionLine;
	}

	public void setTransactionLine(String transactionLine) {
		this.transactionLine = transactionLine;
		this.result = "Awaiting parsing";
	}
	
	public String getResult() {
		return result;
	}

	public void processLine(){

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        
        String input = "{\"transaction\":\""+transactionLine+"\"}";
        String uri = "http://127.0.0.1:8080/function/format-fnb-transaction";
        
        // set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.set("Authorization", "Basic " + "xxxxxxxxxxxx");
        HttpEntity<String> entity = new HttpEntity<String>(input, headers);
        
        ResponseEntity<String> response = restTemplate
                .exchange(uri, HttpMethod.POST, entity, String.class);
        
        result = response.getBody();
        System.out.println("result:");
        System.out.println(result);
		
	}
}
