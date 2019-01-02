package com.log.loggitor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.log.loggitor.domain.App;
import com.log.loggitor.domain.DefectInstance;
import com.log.loggitor.domain.Defects;
import com.log.loggitor.domain.LogFile;
import com.log.loggitor.logProcess.Log;
import com.log.loggitor.logProcess.LogProcess;
import com.log.loggitor.logProcess.LogReader;
import com.log.loggitor.repository.AppRepository;
import com.log.loggitor.repository.DefectInstanceRepository;
import com.log.loggitor.repository.DefectsRepository;
import com.log.loggitor.repository.LogFileRepository;

@SpringBootApplication
public class LoggitorApplication {
	private static final Logger logger=LoggerFactory.getLogger(LoggitorApplication.class);
	@Autowired
	private AppRepository AppRep;
	@Autowired
	private DefectsRepository DefRep;
	@Autowired
	private DefectInstanceRepository DefIRep;
	@Autowired
	private LogFileRepository FileRep;
	
	public static void main(String[] args) {
		SpringApplication.run(LoggitorApplication.class, args);
		logger.info("Its Work !!!!!");
		//ok
	}
	
	@Bean
	CommandLineRunner runner(){
        return args -> {
    		//split the path to take the file name
			String fname="C:\\Users\\arkan\\Downloads\\log\\ARServer.log";
			String strFileName=fname.substring(fname.lastIndexOf("\\")+1);
			//LogReader that read the file
			LogReader lr=new LogReader();
			lr.ReadLog(fname);
			//get the errors list for doing the process
			ArrayList<String> errors=lr.getErrorList();
			//processing the errors list and storing them with counting
			LogProcess process=new LogProcess();
			//Log p=new Log();
			process.analyze(errors);
			//String severity=process.ErrorsPerAppSeverity();
			
			ArrayList<Log> plog=process.getErrorAll();
			FileRep.deleteAll();
			DefRep.deleteAll();
			DefIRep.deleteAll();
			AppRep.deleteAll();
			Date date=Calendar.getInstance().getTime();
			FileRep.save(new LogFile(strFileName, date));
			for(Log b:plog) {
				AppRep.save(new App(b.getErrorName(),b.getErrorType()));
				DefRep.save(new Defects(b.getAppSeverity(), b.getErrorNo(), "Solution"));
			}

          // Save demo data to database
        //AppRep.save(new App("CM","Core"));
        };
      } 

}

