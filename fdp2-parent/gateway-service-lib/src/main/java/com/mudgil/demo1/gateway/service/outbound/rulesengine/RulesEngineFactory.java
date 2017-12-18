package com.mudgil.demo1.gateway.service.outbound.rulesengine;

import com.mudgil.demo1.commons.model.ProjEnums.IpcType;
import com.mudgil.demo1.gateway.service.outbound.impl.direct.MLEngineImplDirect;
import com.mudgil.demo1.gateway.service.outbound.impl.direct.RulesEngineImplDirect;
import com.mudgil.demo1.gateway.service.outbound.impl.rest.MLEngineImplRest;
import com.mudgil.demo1.gateway.service.outbound.impl.rest.RulesEngineImplRest;
import com.mudgil.demo1.gateway.util.config.Config;

public class RulesEngineFactory {
	
	
	public static RulesEngine getEngine() {
		
		RulesEngine engine = null;
		
//		return new RulesEngineImplRest();
		
		String ipcMode = Config.runModeProperties.getIpcModeRules();
		IpcType ipc = IpcType.valueOf(ipcMode.trim().toUpperCase());
		
		switch(ipc) {
			case DIRECT : engine = new RulesEngineImplDirect(); break;
			case REST : engine = new RulesEngineImplRest(); break;
		}
		return engine;		
		
	}
	
	
}
