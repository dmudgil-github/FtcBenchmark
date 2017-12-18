package com.mudgil.demo1.gateway.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.mudgil.demo1.commons.model.MLScore;
import com.mudgil.demo1.commons.model.OriginalRef;
import com.mudgil.demo1.commons.model.PayloadFromDb;
import com.mudgil.demo1.commons.model.RulesEngineInput;
import com.mudgil.demo1.commons.model.RulesEngineOutput;
import com.mudgil.demo1.commons.model.TransactionSilver;
import com.mudgil.demo1.commons.model.TxnGatewayInput;
import com.mudgil.demo1.commons.model.TxnGatewayOutput;
import com.mudgil.demo1.commons.model.MLEngineInput;
import com.mudgil.demo1.commons.model.MLEngineOutput;
import com.mudgil.demo1.commons.model.MLScore.ScoreResCode;
import com.mudgil.demo1.gateway.service.outbound.mlengine.MLEngine;
import com.mudgil.demo1.gateway.service.outbound.mlengine.MLEngineFactory;
import com.mudgil.demo1.gateway.service.outbound.rulesengine.RulesEngine;
import com.mudgil.demo1.gateway.service.outbound.rulesengine.RulesEngineFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service("TxnService")
public class GatewayServiceImpl implements GatewayService{
	
	private static final Logger log = LoggerFactory.getLogger(GatewayServiceImpl.class);
	
	private static final AtomicLong counter = new AtomicLong();
	
	public TxnGatewayOutput processRequest (TxnGatewayInput input) {
		log.trace("processRequest()");

		TransactionSilver txn = input.getTxn();
		PayloadFromDb payloadFromDb = fetchDatafromDb(txn);
		
		MLEngineOutput mlOutput = getMLOutput(txn, payloadFromDb ); 
		RulesEngineOutput rulesOutput = getRulesOutput(txn, payloadFromDb, mlOutput);
		
		TxnGatewayOutput gatewayOutput = prepareGatewayOutput(txn, payloadFromDb, mlOutput, rulesOutput);
		
        
		return gatewayOutput;
		
	}
	
	private PayloadFromDb fetchDatafromDb (TransactionSilver txn ) {
		log.trace("fetchDatafromDb()");
		
		PayloadFromDb payloadFromDb = new PayloadFromDb();
		
		return payloadFromDb;
	}
	
	private TxnGatewayOutput prepareGatewayOutput (TransactionSilver txn,PayloadFromDb payloadFromDb, MLEngineOutput mlOutput , RulesEngineOutput rulesOutput) {	
		log.trace("prepareGatewayOutput()");
		
		String txnId = txn.getExternalTransactionId();
		
		OriginalRef origRef = new OriginalRef();
		origRef.setRef(txnId);
		origRef.setOrigPayLoad(txn);
		
		TxnGatewayOutput gatewayOutput = new TxnGatewayOutput();
		gatewayOutput.setMlScore(mlOutput.getMlScore());
		gatewayOutput.setRulesDecision(rulesOutput.getRulesDecision());
		
		gatewayOutput.setOrigRef(origRef);
		
		return gatewayOutput;

	}
	
	private MLEngineOutput getMLOutput (TransactionSilver txn,PayloadFromDb payloadFromDb) {	
		log.trace("getMLOutput()");

		MLEngineInput input = new MLEngineInput();
		input.setTxn(txn);
		input.setPayloadFromDB(payloadFromDb);

		MLEngine mlEngine = MLEngineFactory.getEngine();
		
		MLEngineOutput mlOutput = mlEngine.getMLOutput(input);
		
		return mlOutput;		
	}
	

	
//	private MLScore getMLScore (MLEngineInput input) {
////		System.out.println("getMLScore() ");		
//		log.trace("getMLScore()");
//
//		PayloadFromDb payload  = input.getPayloadFromDB();
//		TransactionSilver txn = input.getTxn();
//		
//		// Assess the content here and post message to ML engine and get score
//		
//		MLScore mlScore = new MLScore();
//		mlScore.setScore(777);
//		mlScore.setScoreCode(ScoreResCode.ReasonA);		
//		return mlScore;		
//	}
	
	
	private RulesEngineOutput getRulesOutput (TransactionSilver txn, PayloadFromDb payloadFromDb, MLEngineOutput mlOutput) {
		log.trace("getRulesOutput()");
		
		
		RulesEngineInput input = new RulesEngineInput();
		input.setMLEngineOutput(mlOutput);
		input.setTxn(txn);
		input.setPayloadFromDB(payloadFromDb);
		
		RulesEngine rulesEngine = RulesEngineFactory.getEngine();
		
		RulesEngineOutput rulesOutput = rulesEngine.getRulesOutput(input);
		return rulesOutput;
		
	}
	
//	private Decision getRulesDecisionViaRest(RulesEngineInput input) {
//
//	    String scheme = "http";
//	    String host = "localhost";
//	    String port = "8083";
//	    String appContext = "/app-rules-engine";
//	    String baseResPath = "/api";
//	    String apiName = "/rulesengine/";
//	    
//	    String REST_SERVICE_URI = scheme+"://"+host+":"+port+appContext+baseResPath;
//
//		
//    	RestTemplate restTemplate = new RestTemplate();      
//        ResponseEntity<Decision> response = restTemplate.postForEntity(REST_SERVICE_URI+apiName, input, Decision.class);
//        Decision decision = response.getBody();  
//        
//        return decision;
//		
//	}
	
//	private Decision getRulesDecision (RulesEngineInput input) {
////		System.out.println("getRulesDecision() ");
//		log.trace("getRulesDecision()");
//		
//		MLScore mlSCore = input.getMlScore();
//		PayloadFromDb payload  = input.getPayloadFromDB();
//		TransactionSilver txn = input.getTxn();
//		
//		// Asses the input here w.r.t. Business Rules
//		
//		// now preparing the decision
//		
//		Decision decision = new Decision();
//		decision.setDecision(DecisionType.ACCEPT);		
//		decision.setDecisionAction(DecisionActionType.ACTIONA);
//		
//		return decision;
//		
//	}

}
