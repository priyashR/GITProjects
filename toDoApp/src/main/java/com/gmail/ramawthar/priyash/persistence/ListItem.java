package com.gmail.ramawthar.priyash.persistence;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "toDoList")
public class ListItem {
	private Integer itemNumber;
	private String date;
	private Integer orderNumber;
	private String item;
	private String status;
	
	@DynamoDBHashKey
	public Integer getItemNumber() {
		return itemNumber;
	}
	
	@DynamoDBAttribute
	public String getDate() {
		return date;
	}
	
	@DynamoDBAttribute
	public Integer getOrderNumber() {
		return orderNumber;
	}
	
	@DynamoDBAttribute
	public String getItem() {
		return item;
	}
	
	@DynamoDBAttribute
	public String getStatus() {
		return status;
	}
	
	

}
