package com.mudgil.demo1.gateway.service;


import java.util.List;

import com.mudgil.demo1.commons.model.TxnGatewayInput;
import com.mudgil.demo1.commons.model.TxnGatewayOutput;


public interface GatewayService {
	
	public TxnGatewayOutput processRequest (TxnGatewayInput input);
	
}
