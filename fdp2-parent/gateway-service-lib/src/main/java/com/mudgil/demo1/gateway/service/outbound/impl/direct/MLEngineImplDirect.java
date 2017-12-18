package com.mudgil.demo1.gateway.service.outbound.impl.direct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mudgil.demo1.commons.model.MLEngineInput;
import com.mudgil.demo1.commons.model.MLEngineOutput;
import com.mudgil.demo1.gateway.service.outbound.mlengine.MLEngine;
import com.mudgil.demo1.mlengine.service.MLEngineService;
import com.mudgil.demo1.mlengine.service.MLEngineServiceFactory;

public class MLEngineImplDirect implements MLEngine {
	
	public static final Logger log = LoggerFactory.getLogger(MLEngineImplDirect.class);
	
	
	public MLEngineOutput getMLOutput(MLEngineInput input) {
		log.trace("ML getMLOutput()");
		MLEngineOutput output = null;
		MLEngineService mlEngineService = MLEngineServiceFactory.getMLEngineService();
		output = mlEngineService.processRequest(input);  
        
        return output;
		
	}
	
}
