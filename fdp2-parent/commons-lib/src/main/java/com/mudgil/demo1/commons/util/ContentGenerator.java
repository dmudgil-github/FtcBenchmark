package com.mudgil.demo1.commons.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.mudgil.demo1.commons.model.TransactionSilver;

public class ContentGenerator {
	
	

	Random r = null;
	
	public ContentGenerator(Random r ) {
		
		this.r = r; 
		
	}
	
	public ContentGenerator() {
		
		this.r = new Random();
		
	}

	
	public static void main(String[] args) {
		System.out.println("starting ContentGenerator()");
		
		ContentGenerator cg = new ContentGenerator();
		
		TransactionSilver txn = null;
		
			for(int i =0;i < 100; i++) {
				txn = cg.getRandomTransaction();
				
				System.out.println(txn.getPan() + "\t"+txn.getExternalTransactionId());
				
			}
	}
	
	
	/**
	 * @return
	 */
	public TransactionSilver getRandomTransaction() {
		TransactionSilver txn = new TransactionSilver();
		Random r = new Random();
		txn.setExternalTransactionId(""+getTxnId());
		txn.setPan(getPan());
		return txn; 
	}
	

	private int getTxnId() {
		
		
		return 	getRandomNumber(1000000000, 1999999999);
		
	}
	
	private String getPan() {
		StringBuffer buf = new StringBuffer();
		
		buf.append(getBin());
		buf.append(getRandomNumber(10, 99));
		
		for (int i = 0; i < 2; i++) {
			buf.append(getRandomNumber(1001, 9999));
		}
		return buf.toString();
		
	}
	
	private int getRandomNumber(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		return r.ints(min, (max + 1)).findFirst().getAsInt();

	}
	
	private int getBin() {
		
		int [] bins = new int[] {524702, 541288,421316,452421, 465858,465922,476363,475183, 492910,4715232,448445};
		
		 int bin = r.nextInt(((bins.length -1) - 1) + 1) + 1;
		 
		 return bins[bin];
	}
	
	
}
