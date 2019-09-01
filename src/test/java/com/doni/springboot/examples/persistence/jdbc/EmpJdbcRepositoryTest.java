package com.doni.springboot.examples.persistence.jdbc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.doni.springboot.examples.employee.domain.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"h2"})
public class EmpJdbcRepositoryTest {

	@Resource
	EmpJdbcRepository empJdbcRepository;

	@Test
	public void getEmployee() {
		Employee employee = empJdbcRepository.getEmployeeByEmpNo("1");
		assertEquals("1", employee.getEmpNo());
	}

}
