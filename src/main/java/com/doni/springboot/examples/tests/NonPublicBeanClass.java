package com.doni.springboot.examples.tests;

import org.springframework.stereotype.Service;

@Service
public class NonPublicBeanClass {

	private static String name;
	
	private static String getResult(String prefix) {
		return prefix + name;
	}
}
