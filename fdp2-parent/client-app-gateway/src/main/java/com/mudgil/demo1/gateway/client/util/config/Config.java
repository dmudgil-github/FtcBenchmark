package com.mudgil.demo1.gateway.client.util.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Config {
	
    @Autowired
    public GatewayProperties gatewayProperties;
    

    @Autowired
    public void setRulesEngine(GatewayProperties gatewayProperties) {
        this.gatewayProperties = gatewayProperties;
    }

}
