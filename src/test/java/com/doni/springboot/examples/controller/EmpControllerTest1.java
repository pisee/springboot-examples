package com.doni.springboot.examples.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.doni.springboot.examples.domain.Employee;
import com.doni.springboot.examples.service.EmpService;

@RunWith(SpringRunner.class)
public class EmpControllerTest1 {

	EmpController empController;
	EmpService empService;
	
	@Before
	public void setup() {
		empService = mock(EmpService.class);
		empController = new EmpController(empService);
	}
	
	@Test
	public void test() {
		Employee newEmployee = new Employee();
		newEmployee.setEmpNo("1");
		newEmployee.setEmpName("mock");
		newEmployee.setSal(10000);
		when(empService.findById("1")).thenReturn(newEmployee );

		Employee employee = empController.findbyId("1");
		System.out.println(employee);
		
		assertNotNull(employee);
		verify(empService, times(1)).findById("1");
		
	}
}
