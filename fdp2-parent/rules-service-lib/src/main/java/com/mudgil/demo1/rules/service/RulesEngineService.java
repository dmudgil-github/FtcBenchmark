package com.mudgil.demo1.rules.service;


import java.util.List;

import com.mudgil.demo1.commons.model.RulesEngineInput;
import com.mudgil.demo1.commons.model.RulesEngineOutput;


public interface RulesEngineService {
	
	
	public RulesEngineOutput processRequest (RulesEngineInput input);
	
}
