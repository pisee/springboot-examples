package com.doni.springboot.examples.privatetests;

public class NonPublicClass {

	private static String name;
	
	private static String getResult(String prefix) {
		return prefix + name;
	}
}
