package com.log.loggitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggitorApplication {
	private static final Logger logger=LoggerFactory.getLogger(LoggitorApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(LoggitorApplication.class, args);
		logger.info("Its Work !!!!!");
	}

}

