package com.gmail.ramawthar.priyash.queueLogic;

public class ProcessTransactions {
	
	String transactionLine;
	TransactionObj transactionObj = new TransactionObj();

	public ProcessTransactions(String transaction) {
		this.transactionLine = transaction;
	}
	
	public void processTransaction(){
		loadTransactionObj();
	}
	
	private void loadTransactionObj(){
		String formattedLine = transactionLine.replace("{","")
											  .replace("}","")
											  .replace("\"transaction\":\"", "")
											  .replace("\"", "");
		
	}
	
	private String getReferencePath(String tranFlow, String reference){
		
		//call the get reference path service here!!!!
		
		//For now the logic below will be used
		
		if (tranFlow.equalsIgnoreCase("in")){
			return "Income;"+reference;
		}else{
			return "Expense;"+reference;		
		}
		
	}
}
