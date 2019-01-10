package com.log.loggitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.log.loggitor.domain.DefectInstance;
import com.log.loggitor.repository.DefectInstanceRepository;

@RestController
public class DefectInstanceController {
	@Autowired
	private DefectInstanceRepository defIRep;
	@RequestMapping("/defectsInstance")
	public Iterable<DefectInstance> getApps() {
		return defIRep.findAll();

    } 
}
