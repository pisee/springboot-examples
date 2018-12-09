package com.doni.springboot.examples.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CollectionTests {

	@Test
	public void equalityAndIdentity() {
		List<String> lists = new ArrayList<>();
		
		String index1 = new String("1");
		String index2 = new String("1");
		lists.add(index1);
		lists.add(index2);
		
		String string1 = lists.get(0);
		String string2 = lists.get(0);
		
		System.out.println(lists.size());
		assertEquals(true, string1.equals(string2));
		assertEquals(true, string1==string2);
		
	}

}
