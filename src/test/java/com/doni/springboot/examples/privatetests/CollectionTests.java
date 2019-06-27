package com.doni.springboot.examples.privatetests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
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
		assertEquals(true, index1!=index2);
		
		String a = "1";
		String b = "1";
		assertEquals(true, a==b);	
		
	}
	
	@Test
	public void equalityAndIdentity2() {
		List<String> lists = new ArrayList<String>();
		
		lists.add("1");
		lists.add("2");
		
		String string1 = lists.get(0);
		String string2 = lists.get(0);
		
		assertEquals(true, string1.equals(string2));
		assertEquals(true, string1==string2);
	}
	
	@Test
	public void modify() {
		List<CollectionVo> lists = new ArrayList<>();
		
		lists.add(new CollectionVo("a","a"));
		lists.add(new CollectionVo("b","b"));
		lists.add(new CollectionVo("c","c"));
		
		System.out.println(Arrays.toString(lists.toArray()));
		lists.get(1).setName("d");
		System.out.println(Arrays.toString(lists.toArray()));
	}

}

class CollectionVo{
	String name;
	String age;
	public CollectionVo(String name, String age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "CollectionVo [name=" + name + ", age=" + age + "]";
	}
	
}