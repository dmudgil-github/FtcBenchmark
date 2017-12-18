package com.mudgil.demo1.commons.model;

public abstract class Transaction {
	
	public enum TransactionType {
		REFUND("R"),
		CREDIT("C");
		
		private String type;
		private TransactionType(String type) {
			this.type = type;
		}
		public String getType() {
			return type;
		}
	}
	
	
	
}
