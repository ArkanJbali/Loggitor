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
public class App {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long AppID;
	private String AppName,AppType;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="app")
	 @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  	@JsonIgnore
	private List<DefectInstance> defeInstance;
	public App() {
		super();
	}

	public App(String appName, String appType) {
		super();
		AppName = appName;
		AppType = appType;
	}
	

	public App(String appName, String appType, List<DefectInstance> defeInstance) {
		super();
		AppName = appName;
		AppType = appType;
		this.defeInstance = defeInstance;
	}

	public String getAppName() {
		return AppName;
	}

	public void setAppName(String appName) {
		AppName = appName;
	}

	public String getAppType() {
		return AppType;
	}

	public void setAppType(String appType) {
		AppType = appType;
	}
	public List<DefectInstance> getDefeInstance() {
		return defeInstance;
	}

	public void setDefeInstance(List<DefectInstance> defeInstance) {
		this.defeInstance = defeInstance;
	}

	public long getAppID() {
		return AppID;
	}
	
	
}
