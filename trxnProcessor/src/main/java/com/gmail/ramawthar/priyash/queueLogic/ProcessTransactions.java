package com.gmail.ramawthar.priyash.queueLogic;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

import com.gmail.ramawthar.priyash.model.Transaction;
import com.gmail.ramawthar.priyash.service.TransactionService;

public class ProcessTransactions {
	
	String transactionLine;
	TransactionObj transactionObj = new TransactionObj();
	TransactionService transactionService;

	public ProcessTransactions(String transaction, TransactionService transactionService) {
		this.transactionService = transactionService;
		this.transactionLine = transaction;
	}
	
	public void action(){
		loadTransactionObj();
		pushTransactionToDB();
		
	}
	
	private void loadTransactionObj(){
		String formattedLine = transactionLine.replace("{","")
											  .replace("}","")
											  .replace("\"transaction\":\"", "")
											  .replace("transaction:", "")
											  .replace("\"", "");
		
		System.out.println("formatted line - " +formattedLine);
		
		String delimiter = ";";
		StringTokenizer st = new StringTokenizer(formattedLine, delimiter);
		
		String tranType = st.nextElement().toString();
		
		
		
		switch(tranType){
			case "cheqWithdrawal"://tranType
			{
				System.out.println("cheqWithdrawal");
				cheqWithdrawal(formattedLine);
				break;
			}
			case "cheqTransfer"://tranType
			{
				System.out.println("cheqTransfer");
				cheqTransfer(formattedLine);
				break;
			}
			case "cheqPurchase"://tranType
			{
				System.out.println("cheqPurchase");
				cheqPurchase(formattedLine);
				break;
			}
			case "creditPurchase"://tranType
			{
				System.out.println("creditPurchase");
				creditPurchase(formattedLine);
				break;
			}
			case "cheqDeposits"://tranType
			{
				System.out.println("cheqDeposits");
				cheqDeposits(formattedLine);
				break;
			}
		}
		transactionObj.tranRefTree = getReferencePath(transactionObj.tranFlow, transactionObj.tranRef);
		System.out.println(transactionObj.toString());
	}
	

	private void cheqTransfer(String formattedLine){

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
			case 4://tranAcct
			{
				transactionObj.tranAcct = st.nextElement().toString();
				System.out.println(transactionObj.tranAcct);
				System.out.println("index: "+index);
				break;
			}
			case 5://tranRef - use the to account as reference
			{
				transactionObj.tranRef = st.nextElement().toString();
				System.out.println(transactionObj.tranRef);
				System.out.println("index: "+index);
				break;
			}
			case 6://tranCard
			{
				transactionObj.tranFlow = st.nextElement().toString();
				//no card number available, so ignore available for now and use acct number
				transactionObj.tranCard = transactionObj.tranAcct;
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
	}
	
	
	private void cheqPurchase(String formattedLine){

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
			case 4://tranAcct
			{
				transactionObj.tranAcct = st.nextElement().toString();
				System.out.println(transactionObj.tranAcct);
				System.out.println("index: "+index);
				break;
			}
			case 5://ignore available for now
			{
				break;
			}
			case 6://tranCard and tranRef
			{
				transactionObj.tranRef = st.nextElement().toString();
				System.out.println(transactionObj.tranRef);
				System.out.println("index: "+index);
				
				//no card number available, so ignore available and use acct number
				transactionObj.tranCard = transactionObj.tranAcct;
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
	}
	
	
	
	private void creditPurchase(String formattedLine){

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
				st.nextElement().toString();
				//no card number available, so ignore available and use acct number
				transactionObj.tranCard = transactionObj.tranAcct;
				System.out.println(transactionObj.tranCard);
				System.out.println("index: "+index);
				break;
			}case 7://ignore available for now
			{
				st.nextElement().toString();
				break;
			}
			case 8://tranDate
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
			case 9://tranTime
			{
				transactionObj.tranTime = st.nextElement().toString();
				System.out.println(transactionObj.tranTime);
				System.out.println("index: "+index);
				break;
			}
			}
		}
	}
	
	
	private void cheqDeposits(String formattedLine){

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
			case 4://tranAcct
			{
				transactionObj.tranAcct = st.nextElement().toString();
				System.out.println(transactionObj.tranAcct);
				System.out.println("index: "+index);
				break;
			}
			case 5://tranRef
			{
				transactionObj.tranRef = st.nextElement().toString();
				System.out.println(transactionObj.tranRef);
				System.out.println("index: "+index);
				break;
			}
			case 6://tranCard and tranDate
			{
				transactionObj.tranFlow = st.nextElement().toString();
				//no card number available, so ignore available and use acct number
				transactionObj.tranCard = transactionObj.tranAcct;
				System.out.println(transactionObj.tranCard);
				System.out.println("index: "+index);
				
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
			case 7://tranTime
			{
				transactionObj.tranTime = st.nextElement().toString();
				System.out.println(transactionObj.tranTime);
				System.out.println("index: "+index);
				break;
			}
			}
		}
	}
	
	
	
	private void cheqWithdrawal(String formattedLine){
		
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
			case 4://tranAcct
			{
				transactionObj.tranAcct = st.nextElement().toString();
				System.out.println(transactionObj.tranAcct);
				System.out.println("index: "+index);
				break;
			}
			case 5://tranRef
			{
				transactionObj.tranRef = st.nextElement().toString();
				System.out.println(transactionObj.tranRef);
				System.out.println("index: "+index);
				break;
			}
			case 6://tranCard
			{
				transactionObj.tranFlow = st.nextElement().toString();
				//no card number available, so ignore available and use acct number
				transactionObj.tranCard = transactionObj.tranAcct;
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
	
	private void pushTransactionToDB(){
		
		Transaction transaction = new Transaction(transactionObj.tranDate+transactionObj.tranTime+transactionObj.tranRef+Calendar.getInstance().getTimeInMillis(),
												  transactionObj.tranType, 
											  	  transactionObj.tranFlow, 
												  new BigDecimal(transactionObj.tranAmount), 
												  transactionObj.tranRef, 
												  transactionObj.tranRefTree,
												  transactionObj.tranAcct, 
												  transactionObj.tranCard, 
												  transactionObj.tranDate, 
												  transactionObj.tranTime);
		
		
		transactionService.save(transaction);
	}
	
	//public static void main(String arg[]){
		/*String test = "R250.00 withdrawn from cheq a/c..947000 using card..7046 @ Caltex N ATM. Avail R12134. 11Dec 17:52";
		String before = test.substring(0, test.indexOf("using card.."));
		String after = test.substring(test.indexOf("@ ") );
		
		System.out.println(before + after);*/
		
		//ProcessTransactions pt = new ProcessTransactions(
		//		"{\"transaction\": \"creditPurchase;out;808.32;Engen Lonehill Bouleva;947000;7046;8Jan;11:44\"}");
		
		//pt.action();
		
	//}
}
