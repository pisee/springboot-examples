package com.doni.springboot.examples.repository.methods.springjdbc;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.doni.springboot.examples.domain.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"h2"})
public class EmpSpringJdbcRepositoryTest {

	@Resource
	EmpSpringJdbcRepository empSpringJdbcRepository;
	
	@Test
	@Transactional
	public void test() {
		String empNo = "1";
		Employee employee1 = empSpringJdbcRepository.findbyId(empNo);
		Employee employee2 = empSpringJdbcRepository.findbyId(empNo);
		
		System.out.println(employee1);
		
		assertEquals(true, employee1.equals(employee2));
//		assertEquals(true, employee1 == employee2);  // false
	}

}
