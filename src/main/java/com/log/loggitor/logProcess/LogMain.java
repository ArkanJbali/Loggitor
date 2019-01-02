package com.log.loggitor.logProcess;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class LogMain {
	//read a folder files
	static ArrayList<String> files =new ArrayList<String>();
	public static void listFilesForFolder(final File folder) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	            files.add(fileEntry.getPath());
	        }
	    }
	}

	public static void main(String[] args) throws IOException {
		final File folder = new File("C:\\Users\\arkan\\Downloads\\log");
		listFilesForFolder(folder);
		//Files
		
		for(String fname:files) {
			//split the path to take the file name
			String strFileName=fname.substring(fname.lastIndexOf("\\")+1);
			//LogReader that read the file
			LogReader lr=new LogReader();
			lr.ReadLog(fname);
			//get the errors list for doing the process
			ArrayList<String> errors=lr.getErrorList();
			//processing the errors list and storing them with counting
			LogProcess process=new LogProcess();
			Log p=new Log();
			process.analyze(errors);
			String severity=process.ErrorsPerAppSeverity();
			ArrayList<Log> plog=p.getCountErrorObjects();
//			for(Log b:plog)
//				System.out.println(b.getErrorName()+" "+b.getErrorNo()+" "+b.getErrorType());
		@SuppressWarnings("unused")
			//print the summary in external file
			ReportWrite w=new ReportWrite("C:\\Users\\arkan\\Downloads\\report2.txt", plog,strFileName,severity);
		}
	}

}
