package com.gmail.ramawthar.priyash.budgetDataIngestion;

public class ProcessEmails {
	
	public static void main(String arg[]){
		ParseTransactions pt = new ParseTransactions("FNB :-) R15000.00 t/fer from cheq a/c..204327 to Notice a/c..253965 @ Online Banking. Avail R24668. 29Oct 20:33");
		pt.processLine();
	}

}
