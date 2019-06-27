package com.doni.springboot.examples.privatetests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.doni.springboot.examples.privatetests.NonPublicClass;

//@RunWith(PowerMockRunner.class)
public class NonPublicClassPowermockTest {

	@Test
	public void test() throws Exception {
		NonPublicClass targetClass = new NonPublicClass();

		Whitebox.setInternalState(targetClass, "name", "doni");
		String s = Whitebox.<String>getInternalState(targetClass, "name");
		
		String result = (String) Whitebox.invokeMethod(targetClass, "getResult", "hello ");
		assertEquals("doni", s);
		assertEquals("hello doni", result);
	}

}
