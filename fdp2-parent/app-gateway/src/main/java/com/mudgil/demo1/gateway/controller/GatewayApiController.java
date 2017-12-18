package com.mudgil.demo1.gateway.controller;

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

import com.mudgil.demo1.gateway.service.GatewayService;
import com.mudgil.demo1.commons.model.TransactionSilver;
import com.mudgil.demo1.commons.model.TxnGatewayInput;
import com.mudgil.demo1.commons.model.TxnGatewayOutput;

import com.mudgil.demo1.gateway.util.config.RulesEngineProperties;
import com.mudgil.demo1.gateway.util.config.Config;
import com.mudgil.demo1.gateway.util.config.MLEngineProperties;

@RestController
@RequestMapping("/")
public class GatewayApiController {

	public static final Logger log = LoggerFactory.getLogger(GatewayApiController.class);

	@Autowired
	GatewayService service; 
	
	@RequestMapping(value = "/api/gateway/", method = RequestMethod.POST)
	public ResponseEntity<?> getDecision(@RequestBody TxnGatewayInput input, UriComponentsBuilder ucBuilder) {
		log.trace("Receiving Transaction : {}", input);

		HttpHeaders headers = new HttpHeaders();

		TxnGatewayOutput output = service.processRequest(input);
			
		log.info("Returning decision on TransId= "+input.getTxn().getExternalTransactionId());
		
		return new ResponseEntity<TxnGatewayOutput>(output, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> checkRoot() {
			
		String message = "GatewayService status - <h1>Live </h1> api is available at /api/txn/";
		
		log.info("ML properties ="+Config.mlEngineProperties);
		log.info("Rules properties ="+Config.rulesEngineProperties);
		log.info("RunMode properties ="+Config.runModeProperties);
			
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
		
	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public ResponseEntity<?> checkApi() {
			
		String message = "GatewayService status - <h1>Live </h1> api is available at /api/txn/";
		
		log.info("ML properties ="+Config.mlEngineProperties);
		log.info("Rules properties ="+Config.rulesEngineProperties);
		log.info("RunMode properties ="+Config.runModeProperties);
			
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

}
