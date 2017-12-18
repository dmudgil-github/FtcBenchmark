package com.mudgil.demo1.gateway.util.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


import javax.validation.constraints.NotNull;

@Component
@ConfigurationProperties("RunMode")
public class RunModeProperties {

	@NotNull
    private String ipcModeML;

	@NotNull
    private String ipcModeRules;

	public String getIpcModeML() {
		return ipcModeML;
	}

	public void setIpcModeML(String ipcModeML) {
		this.ipcModeML = ipcModeML;
	}

	public String getIpcModeRules() {
		return ipcModeRules;
	}

	public void setIpcModeRules(String ipcModeRules) {
		this.ipcModeRules = ipcModeRules;
	}

	@Override
	public String toString() {
		return "RunModeProperties [ipcModeML=" + ipcModeML + ", ipcModeRules=" + ipcModeRules + "]";
	}

	


}
