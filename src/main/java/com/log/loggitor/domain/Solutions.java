package com.log.loggitor.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Solutions {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long SolutionID;
	String solution,description;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="solution")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  	@JsonIgnore
  	private List<Defects> defectsol;
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
	public long getSolutionID() {
		return SolutionID;
	}
	
	
}
