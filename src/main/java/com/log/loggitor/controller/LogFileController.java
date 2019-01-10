package com.log.loggitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.log.loggitor.domain.LogFile;
import com.log.loggitor.repository.LogFileRepository;

@RestController
public class LogFileController {
	@Autowired
	private LogFileRepository LogFRep;
	@RequestMapping("LogFile")
	public Iterable<LogFile> getApps() {
		return LogFRep.findAll();
    } 
}
