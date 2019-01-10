package com.log.loggitor.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.log.loggitor.domain.App;
import com.log.loggitor.repository.AppRepository;

@RestController
public class AppController {
	@Autowired
	private AppRepository AppRep;
	@RequestMapping("/apps")
	public Iterable<App> getApps() {
		return AppRep.findAll();

    } 
	public List<App> getAllApps(){
		return Arrays.asList(
				new App("BLM","Custom"),
				new App("CM","Custom"),
				new App("JLM","Core")
				);
	}
}
