package com.mudgil.demo1.gateway.service.outbound.mlengine;

import com.mudgil.demo1.commons.model.MLEngineInput;
import com.mudgil.demo1.commons.model.MLEngineOutput;
import com.mudgil.demo1.commons.model.MLScore;

public interface MLEngine {
	
	public MLEngineOutput getMLOutput(MLEngineInput input);
	
}
