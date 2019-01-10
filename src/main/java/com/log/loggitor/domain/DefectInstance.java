package com.log.loggitor.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class DefectInstance {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long SeqID;
	private long AppID,Def_id,Log_id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="app",referencedColumnName="AppID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private App app;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="defect",referencedColumnName="Def_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Defects defect;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="logFile",referencedColumnName="FileID")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private LogFile logFile;
	
	public DefectInstance() {
		super();
	}
	
	public DefectInstance(long appID, long def_id, long log_id) {
		super();
		AppID = appID;
		Def_id = def_id;
		Log_id = log_id;
		//this.app=app;
	}
	

	public DefectInstance(long appID, long def_id, long log_id, App app, Defects defect, LogFile logFile) {
		super();
		AppID = appID;
		Def_id = def_id;
		Log_id = log_id;
		this.app = app;
		this.defect = defect;
		this.logFile = logFile;
	}

	public DefectInstance(long appID, long def_id, long log_id, App app) {
		super();
		AppID = appID;
		Def_id = def_id;
		Log_id = log_id;
		this.app = app;
	}

	public long getAppID() {
		return AppID;
	}
	public void setAppID(long appID) {
		AppID = appID;
	}
	public long getDef_id() {
		return Def_id;
	}
	public void setDef_id(long def_id) {
		Def_id = def_id;
	}
	public long getLog_id() {
		return Log_id;
	}
	public void setLog_id(long log_id) {
		Log_id = log_id;
	}
	public App getApp() {
		return app;
	}
	public void setApp(App app) {
		this.app = app;
	}
}
