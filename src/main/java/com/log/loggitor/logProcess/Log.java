package com.log.loggitor.logProcess;

import java.util.ArrayList;

public class Log {
	private int CountNumber;
	private String errorName;
	private String errorNo;
	private String errorType;
	private String appSeverity;
	public static int CriticalCount=0;
	public static int WarningCount=0;
	public static int ErrorCount=0;
	//list for the errors by app code without repeating
	static ArrayList<Log> CountErrorObjects=null;
	//list for all errors
	static ArrayList<Log> ErrorObjects=null;
	public Log(){
	ErrorObjects=new ArrayList<Log>();
	CountErrorObjects=new ArrayList<Log>();
	}
	
	/*
	 * setters and getters methods 
	 */
	public String getErrorName() {
		return errorName;
	}
	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}
	public String getErrorNo() {
		return errorNo;
	}
	public void setErrorNo(String errorNo) {
		this.errorNo = errorNo;
	}
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	public ArrayList<Log> getErrorObjects() {
		return ErrorObjects;
	}
	public ArrayList<Log> getCountErrorObjects() {
		return CountErrorObjects;
	}
//	public void setCountErrorObjects(Log p) {
//		CountErrorObjects.add(p);
//	}
	public int getCountNumber() {
		return CountNumber;
	}
	public void setCountNumber(int countNumber) {
		CountNumber = countNumber;
	}
	
	public String getAppSeverity() {
		return appSeverity;
	}
	public void setAppSeverity(String appSeverity) {
		this.appSeverity = appSeverity;
	}


	
}
