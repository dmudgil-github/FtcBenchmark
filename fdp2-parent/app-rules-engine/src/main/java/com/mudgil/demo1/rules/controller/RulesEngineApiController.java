package com.mudgil.demo1.rules.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mudgil.demo1.commons.model.RulesEngineInput;
import com.mudgil.demo1.commons.model.RulesEngineOutput;
import com.mudgil.demo1.rules.service.RulesEngineService;



@RestController
@RequestMapping("/")
public class RulesEngineApiController {

	public static final Logger logger = LoggerFactory.getLogger(RulesEngineApiController.class);

	@Autowired
	RulesEngineService service; //Service which will do all data retrieval/manipulation work
	
	@RequestMapping(value = "/api/rulesengine/", method = RequestMethod.POST)
	public ResponseEntity<?> getDecision(@RequestBody RulesEngineInput input, UriComponentsBuilder ucBuilder) {
		logger.trace("Receiving Input into RulesEngine : {}", input);

		HttpHeaders headers = new HttpHeaders();

		RulesEngineOutput rulesOutput = service.processRequest(input);
		
		logger.info("Returning Rules Decision on TransId= "+input.getTxn().getExternalTransactionId());
		
		return new ResponseEntity<RulesEngineOutput>(rulesOutput, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> checkRoot() {
			
		String message = "RulesEngine status is Live <api> is available at /txn/";
		
//		log.info("ML properties ="+Config.mlEngineProperties);
//		log.info("Rules properties ="+Config.rulesEngineProperties);
//		log.info("RunMode properties ="+Config.runModeProperties);
			
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}	

	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public ResponseEntity<?> checkApi() {
			
		String message = "RulesEngine status is Live <api> is available at /txn/";
		
//		log.info("ML properties ="+Config.mlEngineProperties);
//		log.info("Rules properties ="+Config.rulesEngineProperties);
//		log.info("RunMode properties ="+Config.runModeProperties);
			
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}	

}
