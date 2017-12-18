package com.mudgil.demo1.commons.model;

public class MLEngineInput {
	
	private TransactionSilver txn = null;
	private PayloadFromDb payloadFromDB = null;
	
	public TransactionSilver getTxn() {
		return txn;
	}
	public void setTxn(TransactionSilver txn) {
		this.txn = txn;
	}

	public PayloadFromDb getPayloadFromDB() {
		return payloadFromDB;
	}
	public void setPayloadFromDB(PayloadFromDb payloadFromDB) {
		this.payloadFromDB = payloadFromDB;
	}
	
	

}
