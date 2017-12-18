package com.mudgil.demo1.mlengine.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.mudgil.demo1.commons.model.TxnGatewayOutput;
import com.mudgil.demo1.commons.model.MLScore;
import com.mudgil.demo1.commons.model.OriginalRef;
import com.mudgil.demo1.commons.model.PayloadFromDb;
import com.mudgil.demo1.commons.model.RulesEngineOutput;
import com.mudgil.demo1.commons.model.TransactionSilver;

import com.mudgil.demo1.commons.model.MLEngineInput;
import com.mudgil.demo1.commons.model.MLEngineOutput;
import com.mudgil.demo1.commons.model.MLScore.ScoreResCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service("MLService")
public class MLEngineServiceImpl implements MLEngineService{
	
	private static final Logger log = LoggerFactory.getLogger(MLEngineServiceImpl.class);
	
	private static final AtomicLong counter = new AtomicLong();
	
	public MLEngineOutput processRequest (MLEngineInput input) {
		log.trace("MLEngineServiceImpl : getMLScore()");

		PayloadFromDb payload  = input.getPayloadFromDB();
		TransactionSilver txn = input.getTxn();
		
		 return  getMLScore(txn, payload);
	
	}
	
	private MLEngineOutput getMLScore (TransactionSilver txn,PayloadFromDb payloadFromDb) {
		log.trace("MLEngineServiceImpl : getMLScore()");
		
	
		MLScore mlScore = new MLScore();
		mlScore.setScore(777);
		mlScore.setScoreCode(ScoreResCode.ReasonA);		
	
		MLEngineOutput mlOutput = new MLEngineOutput();
		mlOutput.setMlScore(mlScore);
		return mlOutput;		
	}
	
	


}
