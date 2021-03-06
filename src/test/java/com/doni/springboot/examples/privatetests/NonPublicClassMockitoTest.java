package com.doni.springboot.examples.privatetests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.junit.MockitoJUnitRunner;

import com.doni.springboot.examples.privatetests.NonPublicClass;

//@RunWith(MockitoJUnitRunner.class)
public class NonPublicClassMockitoTest {

	@Test
	public void test() throws Exception {
		NonPublicClass targetClass = new NonPublicClass();

		Whitebox.setInternalState(targetClass, "name", "doni");
		String s = (String) Whitebox.getInternalState(targetClass, "name");
		
		assertEquals("doni", s);
	}

}
