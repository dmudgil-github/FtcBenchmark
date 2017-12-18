package com.mudgil.demo1.commons.model;

public class RulesEngineInput {
	

	private TransactionSilver txn = null;
	private PayloadFromDb payloadFromDB = null;
	private MLEngineOutput mlOutput = null;
	
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
	public MLEngineOutput getMLEngineOutput() {
		return mlOutput;
	}
	public void setMLEngineOutput(MLEngineOutput mlOutput) {
		this.mlOutput = mlOutput;
	}
		
}
