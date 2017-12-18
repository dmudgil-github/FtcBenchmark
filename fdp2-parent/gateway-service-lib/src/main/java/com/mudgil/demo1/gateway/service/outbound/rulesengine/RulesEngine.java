package com.mudgil.demo1.gateway.service.outbound.rulesengine;

import com.mudgil.demo1.commons.model.RulesEngineInput;
import com.mudgil.demo1.commons.model.RulesEngineOutput;

public interface RulesEngine {
	
	public RulesEngineOutput getRulesOutput(RulesEngineInput input);
	
}
