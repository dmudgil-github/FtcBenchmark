package com.mudgil.demo1.gateway.service.outbound.mlengine;

import com.mudgil.demo1.commons.model.ProjEnums;
import com.mudgil.demo1.commons.model.ProjEnums.IpcType;
import com.mudgil.demo1.gateway.service.outbound.impl.direct.MLEngineImplDirect;
import com.mudgil.demo1.gateway.service.outbound.impl.rest.MLEngineImplRest;
import com.mudgil.demo1.gateway.util.config.Config;

public class MLEngineFactory {
		
	
	public static MLEngine getEngine() {
		
		MLEngine engine = null;
		
//		return new MLEngineImplRest();
	
		String ipcMode = Config.runModeProperties.getIpcModeML();
		IpcType ipc = IpcType.valueOf(ipcMode.trim().toUpperCase());
		
		switch(ipc) {

			case DIRECT : engine = new MLEngineImplDirect(); break;
			case REST : engine = new MLEngineImplRest(); break;
		}
		return engine;		
	}
	
	
}
