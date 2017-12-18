package com.mudgil.demo1.gateway.service.outbound.impl.direct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mudgil.demo1.commons.model.RulesEngineInput;
import com.mudgil.demo1.commons.model.RulesEngineOutput;
import com.mudgil.demo1.gateway.service.outbound.impl.rest.RulesEngineImplRest;
import com.mudgil.demo1.gateway.service.outbound.rulesengine.RulesEngine;
import com.mudgil.demo1.gateway.util.config.Config;
import com.mudgil.demo1.rules.service.RulesEngineService;
import com.mudgil.demo1.rules.service.RulesEngineServiceFactory;

public class RulesEngineImplDirect implements RulesEngine {
	
	
	public static final Logger log = LoggerFactory.getLogger(RulesEngineImplDirect.class);
	
	
	public RulesEngineOutput getRulesOutput(RulesEngineInput input) {
		log.trace("ML getMLOutput()");
		 RulesEngineOutput output = null;
		 
		RulesEngineService rulesEngineService = RulesEngineServiceFactory.getRulesEngineService();
        output = rulesEngineService.processRequest(input);  
        
        return output;
		
	}	
	
}
