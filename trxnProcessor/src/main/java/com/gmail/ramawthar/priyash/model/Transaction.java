package com.gmail.ramawthar.priyash.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "transactions", type = "_doc")
public class Transaction {
	
	@Id
	private String id;
	private String tranType;
	private String tranFlow;
	private BigDecimal tranAmount;
	private String tranRef;
	private String tranRefTree;    
	private String tranAcct;
	private String tranCard;
	private String tranDate;
	private String tranTime;
	
	public Transaction(String id, String tranType, String tranFlow, BigDecimal tranAmount, String tranRef, String tranRefTree,
			String tranAcct, String tranCard, String tranDate, String tranTime) {
		super();
		this.tranType = tranType;
		this.tranFlow = tranFlow;
		this.tranAmount = tranAmount;
		this.tranRef = tranRef;
		this.tranRefTree = tranRefTree;
		this.tranAcct = tranAcct;
		this.tranCard = tranCard;
		this.tranDate = tranDate;
		this.tranTime = tranTime;
	}

	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public String getTranFlow() {
		return tranFlow;
	}

	public void setTranFlow(String tranFlow) {
		this.tranFlow = tranFlow;
	}

	public BigDecimal getTranAmount() {
		return tranAmount;
	}

	public void setTranAmount(BigDecimal tranAmount) {
		this.tranAmount = tranAmount;
	}

	public String getTranRef() {
		return tranRef;
	}

	public void setTranRef(String tranRef) {
		this.tranRef = tranRef;
	}

	public String getTranRefTree() {
		return tranRefTree;
	}

	public void setTranRefTree(String tranRefTree) {
		this.tranRefTree = tranRefTree;
	}

	public String getTranAcct() {
		return tranAcct;
	}

	public void setTranAcct(String tranAcct) {
		this.tranAcct = tranAcct;
	}

	public String getTranCard() {
		return tranCard;
	}

	public void setTranCard(String tranCard) {
		this.tranCard = tranCard;
	}

	public String getTranDate() {
		return tranDate;
	}

	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}

	public String getTranTime() {
		return tranTime;
	}

	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}
	
	
	
	
}
