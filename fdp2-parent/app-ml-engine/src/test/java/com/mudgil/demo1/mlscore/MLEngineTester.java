package com.mudgil.demo1.mlscore;
 
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mudgil.demo1.commons.model.MLEngineInput;
import com.mudgil.demo1.commons.model.MLEngineOutput;
import com.mudgil.demo1.commons.model.MLScore;
import com.mudgil.demo1.commons.model.OriginalRef;
import com.mudgil.demo1.commons.model.PayloadFromDb;
import com.mudgil.demo1.commons.model.RulesDecision;
import com.mudgil.demo1.commons.model.TransactionSilver;
import com.mudgil.demo1.commons.model.TxnGatewayInput;
import com.mudgil.demo1.commons.model.TxnGatewayOutput;
import com.mudgil.demo1.commons.util.ContentGenerator;


public class MLEngineTester {
 
    public static final String REST_SERVICE_URI = "http://localhost:8082/app-ml-engine/api/mlengine/";
    
	private static final Logger log = LoggerFactory.getLogger(MLEngineTester.class);
	
   
    

  	 private String getRestUri() {
  		 
 		 return REST_SERVICE_URI;
  		 
  	 }
 
    
    private void getMLOutput() {
    	log.trace("getMLOutput()");
    	
//    	log.info("Gateway REST_SERVICE_URI ="+getRestUri());
    	
    	String REST_SERVICE_URI = getRestUri();
    	System.out.println("REST_SERVICE_URI="+REST_SERVICE_URI);
    	    	
    	TxnGatewayInput input = new TxnGatewayInput();
    	TransactionSilver txn = generateNewTxn();    	
    	input.setTxn(txn);
    	
    	RestTemplate restTemplate = new RestTemplate();      
        ResponseEntity<MLEngineOutput> response = restTemplate.postForEntity(REST_SERVICE_URI, input, MLEngineOutput.class);
        MLEngineOutput output = response.getBody();  
        processOutput(output);
        
    }
    
    private void getMLOutputs() {
       log.trace("getMLOutputs() ----------");
        RestTemplate restTemplate = new RestTemplate();      

        MLEngineInput input = null;
    	MLEngineOutput output = null;
        TransactionSilver txn = null;
        ResponseEntity<MLEngineOutput> response = null;
        String REST_SERVICE_URI = getRestUri();
        
        for( int i =0; i < 100; i++) {
        	input = new MLEngineInput();
        	txn = generateNewTxn();
        	PayloadFromDb payloadFromDB = new PayloadFromDb();
        	payloadFromDB.setRecord("record");
        	input.setPayloadFromDB(payloadFromDB);
        	input.setTxn(txn);
        	
        	response = restTemplate.postForEntity(REST_SERVICE_URI, input, MLEngineOutput.class);
        	output = response.getBody();  
            processOutput(output);        	
    	}
    }

    
    public void processOutput(MLEngineOutput output) {

        
        
        MLScore mlScore = output.getMlScore();
        
        
        log.info("ml output ="+mlScore.getScore() +"\t" +mlScore.getScoreCode() );

    }
    
    
    
	public TransactionSilver generateNewTxn() {
		
		ContentGenerator cg = new ContentGenerator();
		
		TransactionSilver txn = null;
		
		txn = cg.getRandomTransaction();
		
		return txn;
		
	}
	
	public static void main(String[] args) {
		log.trace("main()");		
//		MLEngineTester simulator =   SpringApplication.run(MLEngineTester.class, args).getBean(MLEngineTester.class);
        
		MLEngineTester simulator = new MLEngineTester();
		log.info("starting main(...)");		
		
		simulator.getMLOutput();
//		simulator.getMLOutputs();
		
		log.info("... finishing main()");		
	}    
     
 
}