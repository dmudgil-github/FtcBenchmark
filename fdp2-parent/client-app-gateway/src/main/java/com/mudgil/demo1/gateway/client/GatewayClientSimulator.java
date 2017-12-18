package com.mudgil.demo1.gateway.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mudgil.demo1.commons.util.LatencyMeasure;
import com.mudgil.demo1.commons.model.MLScore;
import com.mudgil.demo1.commons.model.OriginalRef;
import com.mudgil.demo1.commons.model.RulesDecision;
import com.mudgil.demo1.commons.model.TransactionSilver;
import com.mudgil.demo1.commons.model.TxnGatewayInput;
import com.mudgil.demo1.commons.model.TxnGatewayOutput;
import com.mudgil.demo1.commons.util.ContentGenerator;
import com.mudgil.demo1.gateway.client.util.config.GatewayProperties;
import com.mudgil.demo1.gateway.client.util.config.GatewayProperties.Cluster;
import com.mudgil.demo1.gateway.client.util.config.Config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@Configuration
@ConfigurationProperties
public class GatewayClientSimulator {
	
	private static final Logger log = LoggerFactory.getLogger(GatewayClientSimulator.class);
	
    private GatewayProperties gatewayProperties;
    
    
  @Autowired
  public void setGatewayProperties(GatewayProperties gatewayProperties) {
      this.gatewayProperties = gatewayProperties;
  }
	

  	 private String getRestUri() {
  		 
  	     String scheme = "http";
  		 String host = gatewayProperties.getCluster().get(0).getHost();
  		 int port = gatewayProperties.getCluster().get(0).getPort();
  		
  		 String appContext = gatewayProperties.getAppPath().getAppContext();
  		 String apiURI = gatewayProperties.getAppPath().getApiURI();

  		 String REST_SERVICE_URI = scheme+"://"+host+":"+port+appContext+apiURI;
  		 return REST_SERVICE_URI;
  		 
  	 }
 
    
    private void getADecision() {
    	log.trace("getADecision()");
    	
//    	log.info("Gateway REST_SERVICE_URI ="+getRestUri());
    	
    	String REST_SERVICE_URI = getRestUri();
    	System.out.println("REST_SERVICE_URI="+REST_SERVICE_URI);
    	    	
    	TxnGatewayInput input = new TxnGatewayInput();
    	TransactionSilver txn = generateNewTxn();    	
    	input.setTxn(txn);
    	
    	RestTemplate restTemplate = new RestTemplate();      
        ResponseEntity<TxnGatewayOutput> response = restTemplate.postForEntity(REST_SERVICE_URI, input, TxnGatewayOutput.class);
        TxnGatewayOutput output = response.getBody();  
        processOutput(output);
        
    }
    
    private void getDecisions() {
       log.trace("getDecisions() ----------");
        RestTemplate restTemplate = new RestTemplate();      

    	TxnGatewayInput input = null;
    	TxnGatewayOutput output = null;
        TransactionSilver txn = null;
        ResponseEntity<TxnGatewayOutput> response = null;
        String REST_SERVICE_URI = getRestUri();
        
        int TIMES = 100;
        int MAX_TIMES = 1000000;
        LatencyMeasure lm = new LatencyMeasure(MAX_TIMES);
        
        for( int i =0; i < TIMES; i++) {
        	
        	lm.startMeasure();
        	input = new TxnGatewayInput();
        	txn = generateNewTxn();
        	input.setTxn(txn);
        	
        	response = restTemplate.postForEntity(REST_SERVICE_URI, input, TxnGatewayOutput.class);            
        	output = response.getBody();  
        	lm.endMeasure();
//            processOutput(output);        	
    	}
        long stats [] = lm.prepareStats();
      
        lm.showWithMethod(stats);
        
        System.out.println("****** head ******");
        lm.statsHead(stats);
        System.out.println("****** tail ******");
        lm.statsTail(stats);
        

    }

    
    public void processOutput(TxnGatewayOutput output) {

        OriginalRef origRef = output.getOrigRef();
        
        MLScore mlScore = output.getMlScore();
        RulesDecision rulesDecision = output.getRulesDecision();
        
        log.info("decision ="+origRef.getRef()+"\t"+ rulesDecision.getDecision() + "\t"+rulesDecision.getDecisionAction() + "\t"+mlScore.getScore() +"\t" +mlScore.getScoreCode() );

    }
    
    
    
	public TransactionSilver generateNewTxn() {
		
		ContentGenerator cg = new ContentGenerator();
		
		TransactionSilver txn = null;
		
		txn = cg.getRandomTransaction();
		
		return txn;
		
	}
	
	public static void main(String[] args) {
		log.trace("main()");		
		GatewayClientSimulator simulator =   SpringApplication.run(GatewayClientSimulator.class, args).getBean(GatewayClientSimulator.class);
        
		log.info("starting main(...)");		
		
//		simulator.getADecision();
		simulator.getDecisions();
		
		log.info("... finishing main()");		
	}
	
	 
}

