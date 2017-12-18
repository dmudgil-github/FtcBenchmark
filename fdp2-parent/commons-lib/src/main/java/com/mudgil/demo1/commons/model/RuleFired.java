package com.mudgil.demo1.commons.model;

public class RuleFired {
	
	public String ruleName = "No Rule";
	public String ruleId = "No ID";
	public String triggerEvt = "No Evt";

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getTriggerEvt() {
		return triggerEvt;
	}

	public void setTriggerEvt(String triggerEvt) {
		this.triggerEvt = triggerEvt;
	}

	@Override
	public String toString() {
		return "RuleFired [ruleName=" + ruleName + ", ruleId=" + ruleId + ", triggerEvt=" + triggerEvt + "]";
	}
	
	

}
