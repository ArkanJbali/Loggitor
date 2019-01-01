package com.log.loggitor.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Solutions {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long SolutionID;
	String solution,description;
	public Solutions(String solution, String description) {
		super();
		this.solution = solution;
		this.description = description;
	}
	public Solutions() {
		super();
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
