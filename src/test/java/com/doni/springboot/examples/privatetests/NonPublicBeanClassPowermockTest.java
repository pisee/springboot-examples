package com.doni.springboot.examples.privatetests;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.reflect.Whitebox;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.doni.springboot.examples.privatetests.NonPublicBeanClass;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NonPublicBeanClassPowermockTest {

	@Resource
	NonPublicBeanClass targetClass;
	
	@Test
	public void test() throws Exception {
		Whitebox.setInternalState(targetClass, "name", "doni");
		String s = Whitebox.<String>getInternalState(targetClass, "name");
		
		String result = (String) Whitebox.invokeMethod(targetClass, "getResult", "hello ");
		assertEquals("doni", s);
		assertEquals("hello doni", result);
	}

}
