package com.doni.springboot.examples.tests;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NonPublicBeanClassTest {

	@Resource
	NonPublicBeanClass targetClass;
	
	@Test
	public void test() {
		ReflectionTestUtils.setField(targetClass , "name", "doni");
		String result= (String)ReflectionTestUtils.invokeMethod(targetClass, "getResult", "hello ");
		
		assertEquals("hello doni", result);
	}

}
