package com.log.loggitor.domain;

import java.util.List;

import javax.persistence.CascadeType;
//JPA
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Defects {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Def_id;
	private String Severity,error_code;
	private long D_sol;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="solution",referencedColumnName="SolutionID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Solutions solution;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="defect")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  	@JsonIgnore
  	private List<DefectInstance> defeInstance;
	public Defects() {
		super();
	}
	
	public Defects(String severity, String error_code, long d_sol, Solutions solution) {
		super();
		Severity = severity;
		this.error_code = error_code;
		D_sol = d_sol;
		this.solution = solution;
	}

	public Defects(String severity, String error_code, long D_sol) {
		super();
		Severity = severity;
		this.error_code = error_code;
		this.D_sol = D_sol;
	}

	public String getSeverity() {
		return Severity;
	}
	public void setSeverity(String severity) {
		Severity = severity;
	}
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public long getD_sol() {
		return D_sol;
	}
	public void setD_sol(long d_sol) {
		D_sol = d_sol;
	}
	public long getDef_id() {
		return Def_id;
	}
	
	
}
