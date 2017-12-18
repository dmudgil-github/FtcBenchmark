package com.mudgil.demo1.gateway.service.outbound.impl.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mudgil.demo1.commons.model.MLEngineInput;
import com.mudgil.demo1.commons.model.MLEngineOutput;
import com.mudgil.demo1.gateway.service.outbound.mlengine.MLEngine;
import com.mudgil.demo1.gateway.util.config.Config;
import com.mudgil.demo1.gateway.util.config.MLEngineProperties;

public class MLEngineImplRest implements MLEngine {
	
	static String scheme = "http";
	static String host = Config.mlEngineProperties.getCluster().get(0).getHost();
	static int port = Config.mlEngineProperties.getCluster().get(0).getPort();
	
	static String appContext = Config.mlEngineProperties.getAppPath().getAppContext();
	static String apiURI = Config.mlEngineProperties.getAppPath().getApiURI();

	static String REST_SERVICE_URI = scheme+"://"+host+":"+port+appContext+apiURI;
	
	public static final Logger log = LoggerFactory.getLogger(MLEngineImplRest.class);
	
	
	public MLEngineOutput getMLOutput(MLEngineInput input) {
		log.trace("ML URI ="+REST_SERVICE_URI);
		
    	RestTemplate restTemplate = new RestTemplate();      
        ResponseEntity<MLEngineOutput> response = restTemplate.postForEntity(REST_SERVICE_URI, input, MLEngineOutput.class);
        MLEngineOutput output = response.getBody();  
        
        return output;
		
	}
	
}
