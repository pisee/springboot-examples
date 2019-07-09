package com.doni.springboot.examples.persistence.jpa.relation.onetoone.twoway;

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
public class HusbandRepositoryTest {

	@Autowired
	HusbandRepository husbandRepository;

	@Autowired
	WifeRepository wifeRepository;
	
	Wife wife;
	Husband husband;

	@Before
	public void setup() {
		wife = new Wife();
		wife.setWifeId("3");
		wife.setWifeName("rena");
		
		husband = new Husband();
		husband.setHusbandId("3");
		husband.setHusbandName("doni");
		husband.setWife(wife);
	}
	
	@Test
	public void save() {
		wifeRepository.save(wife);
		
		husbandRepository.save(husband);
		
	}

}
