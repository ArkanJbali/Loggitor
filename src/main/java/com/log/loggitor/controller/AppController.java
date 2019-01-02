package com.log.loggitor.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.log.loggitor.domain.App;

@RestController
public class AppController {
	@RequestMapping("/apps")
	public List<App> getAllApps(){
		return Arrays.asList(
				new App("BLM","Custom"),
				new App("CM","Custom"),
				new App("JLM","Core")
				);
	}
}
