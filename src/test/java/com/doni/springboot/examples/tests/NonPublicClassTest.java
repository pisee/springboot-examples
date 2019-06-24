package com.doni.springboot.examples.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

public class NonPublicClassTest {

	@Test
	public void test() {
		NonPublicClass targetClass = new NonPublicClass();
		ReflectionTestUtils.setField(targetClass , "name", "doni");
		String result= (String)ReflectionTestUtils.invokeMethod(targetClass, "getResult", "hello ");
		
		assertEquals("hello doni", result);
	}

}
