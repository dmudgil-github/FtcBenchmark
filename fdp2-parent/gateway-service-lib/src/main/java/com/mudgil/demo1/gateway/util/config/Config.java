package com.mudgil.demo1.gateway.util.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Config {
	
    @Autowired
    public static RulesEngineProperties rulesEngineProperties;

    @Autowired
    public static MLEngineProperties mlEngineProperties;
    
    @Autowired
    public  static RunModeProperties runModeProperties;

    
    @Autowired
    public void setRulesEngine(RulesEngineProperties rulesEngineProperties) {
        this.rulesEngineProperties = rulesEngineProperties;
    }


    @Autowired
    public void setMLEngine(MLEngineProperties mlEngineProperties) {
        this.mlEngineProperties = mlEngineProperties;
    }

    @Autowired
    public void setRunMode(RunModeProperties runModeProperties) {
        this.runModeProperties = runModeProperties;
    }

    
}
