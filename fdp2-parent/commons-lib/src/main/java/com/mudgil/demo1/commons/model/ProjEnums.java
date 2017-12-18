package com.mudgil.demo1.commons.model;

public class ProjEnums {
	
	public enum IpcType {
		DIRECT("MethodInvovation"),
		REST("RestInvocation"),
		SOCKET("SocketInvocation");
		
		
		private String type;
		private IpcType(String type) {
			this.type = type;
		}
		public String getType() {
			return type;
		}
	}

}
