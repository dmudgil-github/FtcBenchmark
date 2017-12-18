package com.mudgil.demo1.gateway.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mudgil.demo1.commons.model.MLScore;
import com.mudgil.demo1.commons.model.OriginalRef;
import com.mudgil.demo1.commons.model.TransactionSilver;
import com.mudgil.demo1.commons.util.ContentGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HelloClientSimulator {
	
	private static final Logger log = LoggerFactory.getLogger(HelloClientSimulator.class);
 
    public static final String scheme = "http";
    public static final String host = "localhost";
    public static final String port = "8081";
    public static final String appContext = "/app-gateway";
    public static final String baseResPath = "/api";
    public static final String apiName = "/hello/";
    
    public static final String REST_SERVICE_URI = scheme+"://"+host+":"+port+appContext+baseResPath;
    
    
    private void getHello() {
    	log.trace("getHello()");
    	
    	String input = "No message";
    	RestTemplate restTemplate = new RestTemplate();      
        ResponseEntity<String> response = restTemplate.getForEntity(REST_SERVICE_URI+apiName, String.class, String.class);
        
        String str = response.getBody();  
        processResponse(str);
        
    }
    
    public void processResponse(String str) {
    	
    	log.info("Response received is - "+str);
    	
    }
	
	public static void main(String[] args) {
		
		log.info("This application generates transactions and posts them to the App-Gateway");
		HelloClientSimulator simulator = new HelloClientSimulator();

		simulator.getHello();
	}
}
