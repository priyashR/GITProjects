package com.gmail.ramawthar.priyash.queueLogic;

import java.util.StringTokenizer;

public class ProcessTransactions {
	
	String transactionLine;
	TransactionObj transactionObj = new TransactionObj();

	public ProcessTransactions(String transaction) {
		this.transactionLine = transaction;
	}
	
	public void processTransaction(){
		loadTransactionObj();
	}
	public void action(){
		loadTransactionObj();
	}
	
	private void loadTransactionObj(){
		String formattedLine = transactionLine.replace("{","")
											  .replace("}","")
											  .replace("\"transaction\": \"", "")
											  .replace("\"", "");
		
		System.out.println("formatted line - " +formattedLine);
		
		String delimiter = ";";
		StringTokenizer st = new StringTokenizer(formattedLine, delimiter);
		int index = 0;
		String tranFlow = "";
		
		while (st.hasMoreTokens()){
			index++;
			
			
			switch(index){
			case 1://tranType
			{
				System.out.println(st.nextElement());
				System.out.println("index: "+index);
				break;
			}
			case 2://tranFlow
			{
				
				System.out.println("index: "+index);
				tranFlow = st.nextElement().toString();
				System.out.println(tranFlow);
				break;
			}
			case 3://tranAmount
			{
				System.out.println(st.nextElement());
				System.out.println("index: "+index);
				break;
			}
			case 4://tranRef
			{
				System.out.println(st.nextElement());
				System.out.println("index: "+index);
				break;
			}
			case 5://tranAcct
			{
				System.out.println(st.nextElement());
				System.out.println("index: "+index);
				break;
			}
			case 6://tranCard
			{
				System.out.println(st.nextElement());
				System.out.println("index: "+index);
				break;
			}
			case 7://tranDate
			{
				System.out.println(st.nextElement());
				System.out.println("index: "+index);
				break;
			}
			case 8://tranTime
			{
				System.out.println(st.nextElement());
				System.out.println("index: "+index);
				break;
			}
			
			}
			//tranRefTree = getReferencePath(tranFlow, )
		}
		
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
	
	public static void main(String arg[]){
		
		
		ProcessTransactions pt = new ProcessTransactions(
				"{\"transaction\": \"creditPurchase;out;808.32;Engen Lonehill Bouleva;947000;7046;8Dec;11:44\"}");
		
		pt.action();
		
	}
}
