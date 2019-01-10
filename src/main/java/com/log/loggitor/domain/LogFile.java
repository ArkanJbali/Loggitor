package com.log.loggitor.domain;

import java.util.Date;
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
public class LogFile {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long FileID;
	private String FileName;
	private Date Date_Time;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="logFile")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  	@JsonIgnore
  	private List<DefectInstance> defeInstance;
	public LogFile() {
		super();
	}

	public LogFile(String fileName, Date date_Time) {
		super();
		FileName = fileName;
		Date_Time = date_Time;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public Date getDate_Time() {
		return Date_Time;
	}

	public void setDate_Time(Date date_Time) {
		Date_Time = date_Time;
	}

	public long getFileID() {
		return FileID;
	}
	
	
}
