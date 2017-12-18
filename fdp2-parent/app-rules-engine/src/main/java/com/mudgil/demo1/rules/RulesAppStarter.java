package com.mudgil.demo1.rules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages={"com.mudgil.demo1.rules"}) 
public class RulesAppStarter extends SpringBootServletInitializer {

	   @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(RulesAppStarter.class);
	    }
	   
	public static void main(String[] args) {
		SpringApplication.run(RulesAppStarter.class, args);
	}
}
