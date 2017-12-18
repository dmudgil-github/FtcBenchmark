package com.mudgil.demo1.gateway;
 
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.mudgil.demo1.commons.model.ProjEnums.IpcType;
public class ClientGatewayTester {
 
	public enum ConfigProperties { prop1, prop2 }
	
	public static void main(String[] args) {
		System.out.println("testing");
		
		
		   
		        String[] line = { "prop1" };

		        switch (ConfigProperties.valueOf(line[0].toLowerCase())) {
		        case prop1: System.out.println("Property 1"); break;
		        case prop2: System.out.println("Property 2"); break;
		        }
		   
		
				String ipcMode = "DIRECT";
				
				System.out.println("ipcMode ="+ipcMode);
				IpcType ipc = IpcType.valueOf(ipcMode);
				
				switch(ipc) {
				
				case DIRECT : System.out.println("DIRECT ="+ipc.name() + "\t"+ipc.getType()); break;
				case REST : System.out.println("REST"); break;
				
				}
		

		
	}
	
     
 
}




