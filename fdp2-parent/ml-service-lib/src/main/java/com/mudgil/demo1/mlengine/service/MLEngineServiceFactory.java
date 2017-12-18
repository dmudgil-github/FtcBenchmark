package com.mudgil.demo1.mlengine.service;


import java.util.List;

import com.mudgil.demo1.commons.model.MLEngineInput;
import com.mudgil.demo1.commons.model.MLEngineOutput;

public class MLEngineServiceFactory {
	
	
	public static MLEngineService getMLEngineService () {
		return new MLEngineServiceImpl();
	}
	
}
