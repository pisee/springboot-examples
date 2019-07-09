package com.doni.springboot.examples.persistence.jpa.relation.onetomany.oneway2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("h2")
public class ParentRepositoryTest {

	@Autowired
	ParentRepository parentRepository;
	
	@Autowired
	ChildRepository childRepository;
	
	Child child;
	Parent parent;

	@Before
	public void setup() {
		
		parent = new Parent();
		parent.setFatherName("doni");
		parent.setMotherName("rena");
		
		child = new Child();
		child.setChildName("easyone");
		child.setParent(parent);
	}
	
	@Test
	public void save() {
		Child returnChild = childRepository.save(child);
		Parent returnParent = parentRepository.save(parent);
		
		assertEquals(parent, returnParent);
		assertEquals(child, returnChild);
	}

}
