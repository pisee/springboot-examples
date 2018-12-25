package com.doni.springboot.examples.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@GetMapping("/hello")
//	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		logger.debug("debug Hello");
		logger.info("info Hello");
		logger.warn("warn Hello");
		logger.error("error Hello");
		return "hello";
	}
}
