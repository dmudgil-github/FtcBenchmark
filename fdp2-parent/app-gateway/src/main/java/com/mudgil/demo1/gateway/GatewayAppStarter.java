package com.mudgil.demo1.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages={"com.mudgil.demo1.gateway"}) 
public class GatewayAppStarter extends SpringBootServletInitializer {

	   @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(GatewayAppStarter.class);
	    }
	   
	public static void main(String[] args) {
		SpringApplication.run(GatewayAppStarter.class, args);
	}
}
