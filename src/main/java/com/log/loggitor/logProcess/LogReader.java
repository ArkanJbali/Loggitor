package com.log.loggitor.logProcess;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
public class LogReader {
private ArrayList<String> errorList=null;
	public LogReader(){
		super();
	}
	public void ReadLog(String filename) throws  IOException {
		String name=filename.replace("\\","/");
		Path path1=Paths.get(name);
		errorList=new ArrayList<String>();
				//reading the file using lambda
			try {
					Files.lines(path1).forEach(s->{
						//searching for error that begin with 'caused by'
							if(s.contains("Caused")) {
								s=s.substring(s.indexOf("Caused"));
								//s=s+"\n";
								String values[]=s.split(" ");
								for(String b:values) {
									if(b.startsWith("(") && b.endsWith(")")) {
										//storing it in list
										errorList.add(b);
									}
								}
								
							}
			});
	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public ArrayList<String> getErrorList() {
	return errorList;
}
	
}
