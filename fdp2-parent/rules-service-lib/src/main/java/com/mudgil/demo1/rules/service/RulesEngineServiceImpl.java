package com.mudgil.demo1.rules.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.mudgil.demo1.commons.model.RulesDecision.DecisionType;
import com.mudgil.demo1.commons.model.RulesDecision.DecisionActionType;
import com.mudgil.demo1.commons.model.MLEngineOutput;
import com.mudgil.demo1.commons.model.MLScore;

import com.mudgil.demo1.commons.model.PayloadFromDb;
import com.mudgil.demo1.commons.model.RuleFired;
import com.mudgil.demo1.commons.model.RulesDecision;
import com.mudgil.demo1.commons.model.RulesEngineInput;
import com.mudgil.demo1.commons.model.RulesEngineOutput;
import com.mudgil.demo1.commons.model.TransactionSilver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service("RulesService")
public class RulesEngineServiceImpl implements RulesEngineService{
	
	private static final Logger log = LoggerFactory.getLogger(RulesEngineServiceImpl.class);
	
	private static final AtomicLong counter = new AtomicLong();
	

	
	public RulesEngineOutput processRequest (RulesEngineInput input) {
		log.trace("RulesEngineServiceImpl : processRequest()");
		
		MLEngineOutput mlOutput = input.getMLEngineOutput();
		PayloadFromDb payload  = input.getPayloadFromDB();
		TransactionSilver txn = input.getTxn();
	
		return getRulesDecision(txn, payload, mlOutput);
		
	}
	
	private RulesEngineOutput getRulesDecision (TransactionSilver txn, PayloadFromDb payloadFromDb, MLEngineOutput mlOutput) {
		log.trace("getRulesDecision()");
		
		RulesDecision decision = new RulesDecision();
		decision.setDecision(getDecision(txn,payloadFromDb, mlOutput));		
		decision.setDecisionAction(getAction(txn,payloadFromDb, mlOutput));
		decision.setRulesFired(getFiredRules(txn,payloadFromDb, mlOutput));
		
		RulesEngineOutput rulesOutput = new RulesEngineOutput();
		rulesOutput.setRulesDecision(decision);
		return rulesOutput;
		
	}
	
	private List<RuleFired> getFiredRules(TransactionSilver txn, PayloadFromDb payloadFromDb, MLEngineOutput mlOutput) {

		RuleFired aRule = new RuleFired();
		List<RuleFired> rulesFired = new ArrayList();
		rulesFired.add(aRule);		
		return rulesFired;
	}
	
	private DecisionActionType getAction(TransactionSilver txn, PayloadFromDb payloadFromDb, MLEngineOutput mlOutput) {
		
		return DecisionActionType.ACTIONA;
		
	}

	private DecisionType getDecision(TransactionSilver txn, PayloadFromDb payloadFromDb, MLEngineOutput mlOutput) {
		
		MLScore mlScore = mlOutput.getMlScore();
		
		// Consume these Objects and makes a decision 
		
		return DecisionType.ACCEPT;
	}

}
