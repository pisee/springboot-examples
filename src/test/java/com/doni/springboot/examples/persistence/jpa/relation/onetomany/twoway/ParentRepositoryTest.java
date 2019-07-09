package com.doni.springboot.examples.persistence.jpa.relation.onetomany.twoway;

import java.util.ArrayList;
import java.util.List;

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
		
		child = new Child();
		child.setChildName("easyone");

		parent = new Parent();
		parent.setFatherName("doni");
		parent.setMotherName("rena");
		
		List<Child> childs = new ArrayList<>();
		childs.add(child);

		parent.setChilds(childs );
	}
	
	@Test
	public void save() {
		Parent returnParent = parentRepository.save(parent);
		Child returnChild = childRepository.save(child);
		
//		assertEquals(parent, returnParent);
//		assertEquals(child, returnChild);
	}

}
