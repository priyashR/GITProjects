package com.gmail.ramawthar.priyash.persistence;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "toDoList")
public class ListItem {
	private Integer ItemNumber;
	private String date;
	private Integer orderNumber;
	private String item;
	private String status;
	
	@DynamoDBHashKey(attributeName = "itemNumber")
	public Integer getItemNumber() {
		return ItemNumber;
	}
	
	@DynamoDBAttribute(attributeName = "date")
	public String getDate() {
		return date;
	}
	
	@DynamoDBAttribute(attributeName = "orderNumber")
	public Integer getOrderNumber() {
		return orderNumber;
	}
	
	@DynamoDBAttribute(attributeName = "item")
	public String getItem() {
		return item;
	}
	
	@DynamoDBAttribute(attributeName = "status")
	public String getStatus() {
		return status;
	}
	
	

}
