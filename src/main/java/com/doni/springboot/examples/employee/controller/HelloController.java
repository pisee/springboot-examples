package com.doni.springboot.examples.employee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController {

//	private static final Logger log = LoggerFactory.getLogger(HelloController.class);
	
	@GetMapping("/hello")
//	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		log.debug("debug Hello");
		log.info("info Hello");
		log.warn("warn Hello");
		log.error("error Hello");
		return "Hello World";
	}
}
