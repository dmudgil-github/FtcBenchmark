package com.mudgil.demo1.commons.model;

public class MLScore {

	public enum ScoreResCode {
		ReasonA("A"),
		ReasonB("B"),
		ReasonC("C");
		
		
		private String type;
		private ScoreResCode(String type) {
			this.type = type;
		}
		public String getType() {
			return type;
		}
	}
	
	private int score = 0;
	
	private ScoreResCode scoreCode = null;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public ScoreResCode getScoreCode() {
		return scoreCode;
	}

	public void setScoreCode(ScoreResCode scoreCode) {
		this.scoreCode = scoreCode;
	} 
	
	
	
}
