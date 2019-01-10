package com.log.loggitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.log.loggitor.domain.Defects;
import com.log.loggitor.repository.DefectsRepository;

@RestController
public class DefectsController {
	@Autowired
	private DefectsRepository defRep;
	@RequestMapping("/defects")
	public Iterable<Defects> getApps() {
		return defRep.findAll();

    } 
}
