package com.doni.springboot.examples.employee.service;

import static org.mockito.ArgumentMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.doni.springboot.examples.employee.domain.Employee;
import com.doni.springboot.examples.employee.repository.EmpRepository;
import com.doni.springboot.examples.employee.service.EmpService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("h2")
public class EmpServiceTest {

	@Resource
	EmpService empService;
	
	@MockBean
	EmpRepository empRepository;

	private Employee returnEmployee;
	
	@Before
	public void setup() {
//		returnEmployee = new Employee();
//		returnEmployee.setEmpNo("1");
//		returnEmployee.setEmpName("doni");
//		returnEmployee.setSal(1000);
//		when(empRepository.findById(anyString())).thenReturn(Optional.of(returnEmployee));
	}
	

	@Test
	public void testFindById() {
		returnEmployee = new Employee();
		returnEmployee.setEmpNo("1");
		returnEmployee.setEmpName("doni");
		returnEmployee.setSal(1000);
		when(empRepository.findById(anyString())).thenReturn(Optional.of(returnEmployee));
		
		Employee employee = empService.findById("1");
		
		assertEquals(returnEmployee, employee);
		verify(empRepository, times(1)).findById(anyString());
	}

	@Test
	public void create() {
		Employee newEmployee = new Employee();
		newEmployee.setEmpNo("1");
		newEmployee.setEmpName("doni");
		newEmployee.setSal(1000);

		when(empRepository.findById("1")).thenReturn(Optional.empty());
		when(empRepository.save(newEmployee)).thenReturn(newEmployee);
		
		Employee employee = empService.create(newEmployee);
		
		assertEquals(newEmployee, employee);
	}

	@Test
	public void update() {
		returnEmployee = new Employee();
		returnEmployee.setEmpNo("1");
		returnEmployee.setEmpName("dany");
		returnEmployee.setSal(1000);
		when(empRepository.findById(anyString())).thenReturn(Optional.of(returnEmployee));
		
		
		Employee modifiedEmployee = new Employee();
		modifiedEmployee.setEmpNo("1");
		modifiedEmployee.setEmpName("doni");
		modifiedEmployee.setSal(1000);
		when(empRepository.save(modifiedEmployee)).thenReturn(modifiedEmployee);
		
		Employee employee = empService.update(modifiedEmployee);
		
		assertEquals(modifiedEmployee, employee);
	}
}
