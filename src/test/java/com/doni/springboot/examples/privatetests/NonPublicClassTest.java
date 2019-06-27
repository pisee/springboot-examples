package com.doni.springboot.examples.privatetests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.doni.springboot.examples.privatetests.NonPublicClass;

public class NonPublicClassTest {

	@Test
	public void test() {
		NonPublicClass targetClass = new NonPublicClass();
		ReflectionTestUtils.setField(targetClass , "name", "doni");
		String result= (String)ReflectionTestUtils.invokeMethod(targetClass, "getResult", "hello ");
		
		assertEquals("hello doni", result);
	}

}
