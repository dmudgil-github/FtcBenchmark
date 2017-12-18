package com.mudgil.demo1.commons.model;

public class TxnGatewayOutput {
	
	private OriginalRef origRef = null;

	private MLScore mlScore = null;
	
	private RulesDecision rulesDecision = null;

	
	public OriginalRef getOrigRef() {
		return origRef;
	}

	public void setOrigRef(OriginalRef origRef) {
		this.origRef = origRef;
	}

	public MLScore getMlScore() {
		return mlScore;
	}

	public void setMlScore(MLScore mlScore) {
		this.mlScore = mlScore;
	}

	public RulesDecision getRulesDecision() {
		return rulesDecision;
	}

	public void setRulesDecision(RulesDecision rulesDecision) {
		this.rulesDecision = rulesDecision;
	}

	


	
}
