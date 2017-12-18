package com.mudgil.demo1.gateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.mudgil.demo1.gateway.service.GatewayService;

import com.mudgil.demo1.gateway.util.config.RulesEngineProperties;
import com.mudgil.demo1.gateway.util.config.Config;
import com.mudgil.demo1.gateway.util.config.MLEngineProperties;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

	public static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

	

    @Autowired
    private RulesEngineProperties rulesProperties;
    
    @Autowired
    private MLEngineProperties mlEngineProperties;



    @Autowired
    public void setRulesEngine(RulesEngineProperties rulesProperties) {
        this.rulesProperties = rulesProperties;
    }

    @Autowired
    public void setMLEngine(MLEngineProperties mlEngineProperties) {
        this.mlEngineProperties = mlEngineProperties;
    }
	

	
	@RequestMapping(value = "/hello/", method = RequestMethod.GET)
	public ResponseEntity<?> getDecision() {
			
		String message = "hello from REST";
		
		log.info("ML properties ="+Config.mlEngineProperties);
		log.info("Rules properties ="+Config.rulesEngineProperties);
		log.info("RunMode properties ="+Config.runModeProperties);
			
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	


}
