package com.gmail.ramawthar.priyash.queueLogic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
		
		while (st.hasMoreTokens()){
			index++;
			
			
			switch(index){
			case 1://tranType
			{
				transactionObj.tranType = st.nextElement().toString();
				System.out.println(transactionObj.tranType);
				System.out.println("index: "+index);
				break;
			}
			case 2://tranFlow
			{
				transactionObj.tranFlow = st.nextElement().toString();
				System.out.println(transactionObj.tranFlow);
				System.out.println("index: "+index);
				break;
			}
			case 3://tranAmount
			{
				transactionObj.tranAmount = st.nextElement().toString();
				System.out.println(transactionObj.tranAmount);
				System.out.println("index: "+index);
				break;
			}
			case 4://tranRef
			{
				transactionObj.tranRef = st.nextElement().toString();
				System.out.println(transactionObj.tranRef);
				System.out.println("index: "+index);
				break;
			}
			case 5://tranAcct
			{
				transactionObj.tranAcct = st.nextElement().toString();
				System.out.println(transactionObj.tranAcct);
				System.out.println("index: "+index);
				break;
			}
			case 6://tranCard
			{
				transactionObj.tranCard = st.nextElement().toString();
				System.out.println(transactionObj.tranCard);
				System.out.println("index: "+index);
				break;
			}
			case 7://tranDate
			{
				transactionObj.tranDate = st.nextElement().toString();
				System.out.println(transactionObj.tranDate);
				String month = transactionObj.tranDate.substring(transactionObj.tranDate.length()-3);
				String day = transactionObj.tranDate.substring(0,transactionObj.tranDate.length()-3);
				String year = (Calendar.getInstance().get(Calendar.YEAR))+"";
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MMM-dd");
				Date dateString = null;
				try {
					dateString = format.parse(year+"-"+month+"-"+day);
					if (dateString.getMonth() > Calendar.getInstance().get(Calendar.MONTH)){
						dateString.setYear(dateString.getYear()-1);
					}
				//Remember we can only load a years worth of data upfront because if 
				//the current month is less than the transaction month, we take it that 
				//the transaction occurred last year
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//System.out.println("month: " + month);
				//System.out.println("day: " + day);
				//System.out.println("year: " + year);
				//System.out.println("date: " + dateString.toString());
				
				SimpleDateFormat formatBack = new SimpleDateFormat("yyyy-MM-dd");
				transactionObj.tranDate = formatBack.format(dateString);
				System.out.println(transactionObj.tranDate+" (formatted)");
				System.out.println("index: "+index);
				break;
			}
			case 8://tranTime
			{
				transactionObj.tranTime = st.nextElement().toString();
				System.out.println(transactionObj.tranTime);
				System.out.println("index: "+index);
				break;
			}
			}
		}
		transactionObj.tranRefTree = getReferencePath(transactionObj.tranFlow, transactionObj.tranRef);
		System.out.println(transactionObj.toString());
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
				"{\"transaction\": \"creditPurchase;out;808.32;Engen Lonehill Bouleva;947000;7046;8Jan;11:44\"}");
		
		pt.action();
		
	}
}
