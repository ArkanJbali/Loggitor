package com.log.loggitor.logProcess;
import java.util.ArrayList;

//task
public class LogProcess {
	//counter for all errors
public static int errorCount=0;
Log log=new Log();
ArrayList<Log> ErrorObjects;
ArrayList<Log> CountErrorObjects;
ArrayList<Log> ErrorAll=null;
	public LogProcess() {
		super();
		ErrorAll=new ArrayList<Log>();
		ErrorObjects=log.getErrorObjects();
		CountErrorObjects=log.getCountErrorObjects();
	}
	private void DoProcess(ArrayList<String> errorList) {
		//taking the string then split it by error name, type, app code and counting it then
		//storing it in object
		for(String e:errorList) {
			Log logprocess=new Log();
			int index=e.indexOf("-");
			String str=e.substring(1,index-1);
			logprocess.setErrorName(str);
			String errorno=e.substring(index+1,e.length()-1);
			logprocess.setErrorNo(errorno);
			if(e.charAt(index-1)=='1'){
				logprocess.setErrorType("core");
			}
			else {
				logprocess.setErrorType("custom");
			}
		    if(Integer.parseInt(errorno)%10>=1 && Integer.parseInt(errorno)%10<=3) {
				logprocess.setAppSeverity("Critical");
				Log.CriticalCount++;
			}
		    else if(Integer.parseInt(errorno)%10>=4 && Integer.parseInt(errorno)%10<=6) {
				logprocess.setAppSeverity("Error");
				Log.ErrorCount++;
			}
		    else {
		    	logprocess.setAppSeverity("Warning");
		    	Log.WarningCount++;
		    }
			errorCount++;
			//adding this object for list
			
			ErrorObjects.add(logprocess);
			ErrorAll.add(logprocess);
		}
		
	}
	//this method that store the objects that not repeated in the list
	public void analyze(ArrayList<String> errorList) {
		DoProcess(errorList);
		ArrayList<Log> errors=new ArrayList<Log>();
		errors.addAll(ErrorObjects);
		ErrorAll.addAll(ErrorObjects);
		for(int i=0;i<errors.size();i++) {
			String name=errors.get(i).getErrorName();
			String no=errors.get(i).getErrorNo();
			String type=errors.get(i).getErrorType();
			String severity=errors.get(i).getAppSeverity();
			int count=0;
			for(int j=0;j<errors.size();j++) {
				if(name.equals(errors.get(j).getErrorName()) && no.equals(errors.get(j).getErrorNo()) && type.equals(errors.get(j).getErrorType())) {
					if(count!=0) {
					errors.remove(j);
					j--;
					}
					count++;
					
			}

		}
			//Log.ErrorObjects=ErrorObjects;
			//Error here
			Log LogObj=new Log();
			LogObj.setErrorName(name);
			LogObj.setErrorNo(no);
			LogObj.setErrorType(type);
			LogObj.setAppSeverity(severity);
			LogObj.setCountNumber(count);
			CountErrorObjects.add(LogObj);
			//System.out.println(name+" "+no+" "+type+" "+count);
	}
		Log.CountErrorObjects=CountErrorObjects;
	}
public String ErrorsPerAppSeverity() {
	StringBuffer buffer=new StringBuffer();
	ArrayList<Log> perApp=new ArrayList<Log>();
	perApp.addAll(ErrorObjects);
	int count=0;
	for(int i=0;i<perApp.size();i++) {
		count=0;
	String name=perApp.get(i).getErrorName();
	//String no=perApp.get(i).getErrorNo();
	String type=perApp.get(i).getErrorType();
	String severity=perApp.get(i).getAppSeverity();
	int c=perApp.get(i).getCountNumber();
	count+=c;
	for(int j=0;j<perApp.size();j++) {
		if(type.equals(perApp.get(j).getErrorType()) && severity.equals(perApp.get(j).getAppSeverity())) {
			if(count!=0) {
			perApp.remove(j);
			j--;
			}
			count++;
		}
	}
	buffer.append("   -Error Name: "+name+" - "/*+"Number: "+no+" - "*/+"Type: "+type+" - "+"Severity: "+severity+" - "+"Count: "+count);
	buffer.append("\r\n");
	}
	//System.out.print(buffer.toString());
return buffer.toString();
}
public  ArrayList<Log> getErrorAll() {
	return ErrorAll;
}

public  void setErrorAll(ArrayList<Log> errorAll) {
	ErrorAll = errorAll;
}
}