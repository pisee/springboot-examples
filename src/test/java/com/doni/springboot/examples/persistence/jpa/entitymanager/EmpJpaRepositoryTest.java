package com.doni.springboot.examples.persistence.jpa.entitymanager;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.doni.springboot.examples.employee.domain.Employee;
import com.doni.springboot.examples.persistence.jpa.entitymanager.EmpJpaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("h2")
public class EmpJpaRepositoryTest {

	@Resource
	EmpJpaRepository empJpaRepository;
	
	@Test
	@Transactional
	public void test() {
		String empNo = "1";
		Employee employee1 = empJpaRepository.getEmployeeByEmpNo(empNo );
		Employee employee2 = empJpaRepository.getEmployeeByEmpNo(empNo );
		System.out.println(employee1);
		System.out.println(employee2);
		
		if(employee1 != null) {
			assertEquals(true, employee1.equals(employee2));
		}
		assertEquals(true, employee1 == employee2);	// true

	}

}
