package com.log.loggitor.logProcess;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;


public class ReportWrite {
	private ArrayList<Log> logprocess=null;
	public String strFileName=null;
	public String severity=null;
	public static final String newLine="\r\n";
	 
	public ReportWrite(String filename,ArrayList<Log> logprocesses,String strFileName,String severity){
		super();
		this.logprocess=logprocesses;
		this.strFileName=strFileName;
		this.severity=severity;
		ReportWriter(filename);
	}
	private void ReportWriter(String filename) {
		//reading file using lambda
		String name=filename.replace("\\","/");
		Path path=Paths.get(name);
					try {
						Files.write(path, doWrite().getBytes(), StandardOpenOption.APPEND);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
	}
	//assembling the report file
	private String doWrite() {
		
		StringBuffer b=new StringBuffer();
		b.append("***************************************");
		b.append(newLine);
		b.append("=>File: "+strFileName);
		b.append(newLine);
		b.append("***************************************");
		b.append(newLine);
		if(logprocess.isEmpty()) {
			b.append("No Erros in this file.");
			b.append(newLine);
			b.append("----------------------------------");
			b.append(newLine);
		}
		else {
		for(Log l:logprocess) {
			b.append("Error Name: ");
			b.append(l.getErrorName());
			b.append(newLine);
			b.append("Error Number: ");
			b.append(l.getErrorNo());
			b.append(newLine);
			b.append("Error Type: ");
			b.append(l.getErrorType());
			b.append(newLine);
			b.append("Error Count: ");
			b.append(l.getCountNumber());
			b.append(newLine);
			b.append("Error Severity: ");
			b.append(l.getAppSeverity());
			b.append(newLine);
			b.append("----------------------------------");
			b.append(newLine);
		}
		b.append("=>Number of defects per severity: ");
		b.append(newLine);
		String count1=String.valueOf(Log.CriticalCount);
		b.append("   -Number of defects with critical severity are: ");
		b.append(count1);
		b.append(newLine);
		String count2=String.valueOf(Log.WarningCount);
		b.append("   -Number of defects with warning severity are: ");
		b.append(count2);
		b.append(newLine);
		String count3=String.valueOf(Log.ErrorCount);
		b.append("   -Number of defects with error severity are: ");
		b.append(count3);
		b.append(newLine);
		b.append(newLine);
		Log.CriticalCount=0;Log.ErrorCount=0;Log.WarningCount=0;
		String count=String.valueOf(LogProcess.errorCount);
		b.append("=>Number of defects per app severity: ");
		b.append(newLine);
		//add f
		b.append(severity);
		b.append(newLine);
		b.append(newLine);
		b.append("\t=>Number Of All defects: ");
		b.append(count);
		b.append(newLine);
		//b.append("----------------------------------");
		b.append(newLine);
		}
		//System.out.println(b.toString());
		return b.toString();
	}

}
