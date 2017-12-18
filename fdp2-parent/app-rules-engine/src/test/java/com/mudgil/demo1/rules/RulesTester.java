package com.mudgil.demo1.rules;
 
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mudgil.demo1.commons.model.MLEngineInput;
import com.mudgil.demo1.commons.model.MLEngineOutput;
import com.mudgil.demo1.commons.model.MLScore;
import com.mudgil.demo1.commons.model.MLScore.ScoreResCode;
import com.mudgil.demo1.commons.model.PayloadFromDb;
import com.mudgil.demo1.commons.model.RulesDecision;
import com.mudgil.demo1.commons.model.RulesEngineInput;
import com.mudgil.demo1.commons.model.RulesEngineOutput;
import com.mudgil.demo1.commons.model.TransactionSilver;
import com.mudgil.demo1.commons.model.TxnGatewayInput;
import com.mudgil.demo1.commons.util.ContentGenerator;

public class RulesTester {
 
    public static final String REST_SERVICE_URI = "http://localhost:8083/app-rules-engine/api/rulesengine/";
    
    
	private static final Logger log = LoggerFactory.getLogger(RulesTester.class);
	
   
    

  	 private String getRestUri() {
  		 
 		 return REST_SERVICE_URI;
  		 
  	 }
 
    
    private void getRulesOutput() {
    	log.trace("getRulesOutput()");
    	
//    	log.info("Gateway REST_SERVICE_URI ="+getRestUri());
    	
    	String REST_SERVICE_URI = getRestUri();
    	System.out.println("REST_SERVICE_URI="+REST_SERVICE_URI);
    	    	
//    	RulesEngineInput input = new RulesEngineInput();
//    	TransactionSilver txn = generateNewTxn();    	
//    	input.setTxn(txn);
//
//    	PayloadFromDb payloadFromDB = new PayloadFromDb();
//    	payloadFromDB.setRecord("record");
//    	input.setPayloadFromDB(payloadFromDB);
//
//    	MLEngineOutput mlOutput = new MLEngineOutput();
//    	MLScore mlSCore = new MLScore();
//    	mlSCore.setScore(444);
//    	mlSCore.setScoreCode(ScoreResCode.ReasonB);
//    	mlOutput.setMlScore(mlSCore);
//    	input.setMLEngineOutput(mlOutput);
//
//    	input.setMLEngineOutput(mlOutput);
    	
    	RulesEngineInput input = generateRulesEngineInput();       	
       	

    	RestTemplate restTemplate = new RestTemplate();      
        ResponseEntity<RulesEngineOutput> response = restTemplate.postForEntity(REST_SERVICE_URI, input, RulesEngineOutput.class);
        RulesEngineOutput output = response.getBody();  
        processOutput(output);
        
    }
    
    private void getRulesOutputs() {
       log.trace("getRulesOutputs() ----------");
        RestTemplate restTemplate = new RestTemplate();      

        RulesEngineInput input = null;
        RulesEngineOutput output = null;
        TransactionSilver txn = null;
        ResponseEntity<RulesEngineOutput> response = null;
        String REST_SERVICE_URI = getRestUri();
        
        for( int i =0; i < 100; i++) {
        	
        	input = generateRulesEngineInput();       	
        	response = restTemplate.postForEntity(REST_SERVICE_URI, input, RulesEngineOutput.class); 
            output = response.getBody();  
            processOutput(output);
        	
            
    	}
    }

    public RulesEngineInput generateRulesEngineInput() {
    	
    	RulesEngineInput input = new RulesEngineInput();

    	input.setTxn(generateNewTxn());        	
    	input.setPayloadFromDB(generatePayloadDromDb());
    	input.setMLEngineOutput(generateMLEngineOutput());
    	return input;
    	
    }
    
    public PayloadFromDb generatePayloadDromDb() {
    	PayloadFromDb payloadFromDB = new PayloadFromDb();
    	payloadFromDB.setRecord("record");
    	return payloadFromDB;
    }
    
    public MLEngineOutput generateMLEngineOutput() {
    	MLEngineOutput mlOutput = new MLEngineOutput();
    	MLScore mlSCore = new MLScore();
    	mlSCore.setScore(444);
    	mlSCore.setScoreCode(ScoreResCode.ReasonB);
    	mlOutput.setMlScore(mlSCore);
    	return mlOutput;
    }
    
    public void processOutput(RulesEngineOutput output) {

        
        
        RulesDecision decision = output.getRulesDecision();
        
        
        log.info("decision ="+decision.getDecision() +"\t" +decision.getDecisionAction()+ "\t"+decision.getRulesFired() );

    }
    
    
    
	public TransactionSilver generateNewTxn() {
		
		ContentGenerator cg = new ContentGenerator();
		
		TransactionSilver txn = null;
		
		txn = cg.getRandomTransaction();
		
		return txn;
		
	}
	
	public static void main(String[] args) {
		log.trace("main()");		
//		RulesTester simulator =   SpringApplication.run(RulesTester.class, args).getBean(RulesTester.class);
		RulesTester simulator = new RulesTester(); 
		log.info("starting main(...)");		
		
		simulator.getRulesOutput();
//		simulator.getRulesOutputs();
		
		log.info("... finishing main()");		
	}    
     
     
 
}