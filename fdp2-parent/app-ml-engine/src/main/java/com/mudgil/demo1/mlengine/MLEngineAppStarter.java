package com.mudgil.demo1.mlengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


//@SpringBootApplication(scanBasePackages={"com.mudgil.demo1.mlengine"})// same as @Configuration @EnableAutoConfiguration @ComponentScan combined
//public class MLEngineAppStarter {
//
//	public static void main(String[] args) {
//		SpringApplication.run(MLEngineAppStarter.class, args);
//	}
//}


@SpringBootApplication(scanBasePackages={"com.mudgil.demo1.mlengine"}) 
public class MLEngineAppStarter extends SpringBootServletInitializer {

	   @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(MLEngineAppStarter.class);
	    }
	   
	public static void main(String[] args) {
		SpringApplication.run(MLEngineAppStarter.class, args);
	}
}
