package com.gmail.ramawthar.priyash.budgetDataIngestion;

public class parseTransactions {
	
	String transactionLine;
	String result;

	public parseTransactions(String transactionLine) {
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
		
		
	}
}
