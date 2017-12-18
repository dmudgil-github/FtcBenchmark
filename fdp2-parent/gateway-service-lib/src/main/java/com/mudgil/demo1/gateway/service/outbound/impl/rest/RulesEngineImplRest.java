package com.mudgil.demo1.gateway.service.outbound.impl.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mudgil.demo1.commons.model.RulesEngineInput;
import com.mudgil.demo1.commons.model.RulesEngineOutput;
import com.mudgil.demo1.gateway.service.outbound.rulesengine.RulesEngine;
import com.mudgil.demo1.gateway.util.config.Config;

public class RulesEngineImplRest implements RulesEngine {
	
	static String scheme = "http";
	static String host = Config.rulesEngineProperties.getCluster().get(0).getHost();
	static int port = Config.rulesEngineProperties.getCluster().get(0).getPort();
	
	static String appContext = Config.rulesEngineProperties.getAppPath().getAppContext();
	static String apiURI = Config.rulesEngineProperties.getAppPath().getApiURI();

	static String REST_SERVICE_URI = scheme+"://"+host+":"+port+appContext+apiURI;
	public static final Logger log = LoggerFactory.getLogger(RulesEngineImplRest.class);
	
	public RulesEngineOutput getRulesOutput (RulesEngineInput input) {
		log.trace("ML REST_SERVICE_URI ="+REST_SERVICE_URI);

		
    	RestTemplate restTemplate = new RestTemplate();      
        ResponseEntity<RulesEngineOutput> response = restTemplate.postForEntity(REST_SERVICE_URI, input, RulesEngineOutput.class);
        RulesEngineOutput output = response.getBody();  
        
        return output;
		
	}
}
