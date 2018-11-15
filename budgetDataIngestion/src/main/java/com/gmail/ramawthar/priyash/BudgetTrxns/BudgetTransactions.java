package com.gmail.ramawthar.priyash.BudgetTrxns;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.gmail.ramawthar.priyash.interfaces.ProcessEmail;

public class BudgetTransactions implements ProcessEmail{
	
	String emailBody;
	String result;

	public BudgetTransactions(String transactionLine) {
		super();
		this.emailBody = transactionLine;
		this.result = "Awaiting parsing";
	}

	public String getTransactionLine() {
		return emailBody;
	}

	public void setTransactionLine(String transactionLine) {
		this.emailBody = transactionLine;
		this.result = "Awaiting parsing";
	}
	
	public String getResult() {
		return result;
	}

	public void parseBody(){

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        
        String input = "{\"transaction\":\""+emailBody.replace("\n", "")+"\"}";
        System.out.println("input: "+input);
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
