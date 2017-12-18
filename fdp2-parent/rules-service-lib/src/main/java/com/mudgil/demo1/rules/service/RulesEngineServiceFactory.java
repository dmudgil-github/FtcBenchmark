package com.mudgil.demo1.rules.service;


import java.util.List;

import com.mudgil.demo1.commons.model.MLEngineInput;
import com.mudgil.demo1.commons.model.MLEngineOutput;

public class RulesEngineServiceFactory {
	
	
	public static RulesEngineService getRulesEngineService () {
		return new RulesEngineServiceImpl();
	}
	
}
