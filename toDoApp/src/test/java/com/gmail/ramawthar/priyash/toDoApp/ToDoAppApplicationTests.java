package com.gmail.ramawthar.priyash.toDoApp;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.gmail.ramawthar.priyash.persistence.ListItem;
import com.gmail.ramawthar.priyash.persistence.ListItemRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ToDoAppApplication.class)
@WebAppConfiguration
public class ToDoAppApplicationTests {
	
	private DynamoDBMapper dynamoDBMapper;
	  
    @Autowired
    private AmazonDynamoDB amazonDynamoDB;
  
    @Autowired
    ListItemRepository repository;
    
    @Before
    public void setup() throws Exception {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
          
        //CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Book.class);
        //tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
        //amazonDynamoDB.createTable(tableRequest);
          
        // your code here...
  
        //dynamoDBMapper.batchDelete((List<Book>)repository.findAll());
    }
    
    
	@Test
	public void contextLoads() {
		List<ListItem> taskList = (List<ListItem>) repository.findAll();
	}

}
