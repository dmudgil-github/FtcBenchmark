package com.mudgil.demo1.mlengine.controller;


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

import com.mudgil.demo1.commons.model.MLEngineInput;
import com.mudgil.demo1.commons.model.MLEngineOutput;
import com.mudgil.demo1.commons.model.MLScore;
import com.mudgil.demo1.mlengine.service.MLEngineService;


@RestController
@RequestMapping("/")
public class MLEngineApiController {

	public static final Logger logger = LoggerFactory.getLogger(MLEngineApiController.class);

	@Autowired
	MLEngineService service; 

	@RequestMapping(value = "/api/mlengine/", method = RequestMethod.POST)
	public ResponseEntity<?> getDecision(@RequestBody MLEngineInput input, UriComponentsBuilder ucBuilder) {
		logger.trace("Receiving Input into MLEngine : {}", input);

		HttpHeaders headers = new HttpHeaders();
		

		MLEngineOutput mlOutput = service.processRequest(input);
		logger.info("Returning ML Output on TransId= "+input.getTxn().getExternalTransactionId());
		
		return new ResponseEntity<MLEngineOutput>(mlOutput, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> checkRoot() {
			
		String message = "MLEngineService status is Live <api> is available at api/mlengine/";
		
//		log.info("ML properties ="+Config.mlEngineProperties);
//		log.info("Rules properties ="+Config.rulesEngineProperties);
//		log.info("RunMode properties ="+Config.runModeProperties);
			
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
		
	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public ResponseEntity<?> checkApi() {
			
		String message = "MLEngineService status is Live <api> is available at api/mlengine/";
		
//		log.info("ML properties ="+Config.mlEngineProperties);
//		log.info("Rules properties ="+Config.rulesEngineProperties);
//		log.info("RunMode properties ="+Config.runModeProperties);
			
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	
}
