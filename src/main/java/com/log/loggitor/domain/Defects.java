package com.log.loggitor.domain;

//JPA
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Defects {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Def_id;
	private String Severity,error_code;
	private long D_sol;
	public Defects() {
		super();
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
	
}
