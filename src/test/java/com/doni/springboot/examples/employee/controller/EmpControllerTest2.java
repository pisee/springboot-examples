package com.doni.springboot.examples.employee.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.doni.springboot.examples.employee.controller.EmpController;
import com.doni.springboot.examples.employee.domain.Employee;
import com.doni.springboot.examples.employee.domain.Result;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("h2")
public class EmpControllerTest2 {

	@Autowired
	EmpController empController;
	
	@Test
	public void test() {
		Result<Employee> employee = empController.findbyIdWithresult("1");
		System.out.println(employee);
		
		assertNotNull(employee);
	}
}
