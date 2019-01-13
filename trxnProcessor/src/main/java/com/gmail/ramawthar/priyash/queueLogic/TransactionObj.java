package com.gmail.ramawthar.priyash.queueLogic;



public class TransactionObj {
	String tranType;
	String tranFlow;
	String tranAmount;
	String tranRef;
	String tranRefTree;
	String tranAcct;
	String tranCard;
	String tranDate;
	String tranTime;
	
	public TransactionObj() {
		super();
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

	public String getTranAmount() {
		return tranAmount;
	}

	public void setTranAmount(String tranAmount) {
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

	@Override
	public String toString() {
		return "TransactionObj [tranType=" + tranType + ", tranFlow=" + tranFlow + ", tranAmount=" + tranAmount
				+ ", tranRef=" + tranRef + ", tranRefTree=" + tranRefTree + ", tranAcct=" + tranAcct + ", tranCard="
				+ tranCard + ", tranDate=" + tranDate + ", tranTime=" + tranTime + "]";
	}
	
	
	
}
