package com.mudgil.demo1.commons.model;

import java.util.ArrayList;
import java.util.List;

public class RulesDecision {
	
	public enum DecisionType {
		ACCEPT("A"),
		DECLINE("D"),
		REFER("R");
		
		
		private String type;
		private DecisionType(String type) {
			this.type = type;
		}
		public String getType() {
			return type;
		}
	}
	
	public enum DecisionActionType {
		ACTIONA("A"),
		ACTIONB("B"),
		ACTIONC("C");
		
		
		private String type;
		private DecisionActionType(String type) {
			this.type = type;
		}
		public String getType() {
			return type;
		}
	}
	
	public RulesDecision () {
		rulesFired = new ArrayList();
	}
	
	private DecisionType decision = null;	
	private DecisionActionType decisionAction = null;
	private List <RuleFired> rulesFired = null;

	public DecisionType getDecision() {
		return decision;
	}

	public void setDecision(DecisionType decision) {
		this.decision = decision;
	}

	public DecisionActionType getDecisionAction() {
		return decisionAction;
	}

	public void setDecisionAction(DecisionActionType decisionAction) {
		this.decisionAction = decisionAction;
	}

	public List<RuleFired> getRulesFired() {
		return rulesFired;
	}

	public void setRulesFired(List<RuleFired> rulesFired) {
		this.rulesFired = rulesFired;
	}

	public void addRulesFired(RuleFired rulesFired) {
		this.rulesFired.add(rulesFired);
	}

	
}
