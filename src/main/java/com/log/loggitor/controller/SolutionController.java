package com.log.loggitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.log.loggitor.domain.Solutions;
import com.log.loggitor.repository.SolutionRepository;

@RestController
public class SolutionController {
	@Autowired
	private SolutionRepository SolRep;
	@RequestMapping("/solution")
	public Iterable<Solutions> getApps() {
		return SolRep.findAll();

    } 	
}
