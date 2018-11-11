package com.doni.springboot.examples.service;

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
import org.springframework.test.context.junit4.SpringRunner;

import com.doni.springboot.examples.domain.Employee;
import com.doni.springboot.examples.repository.EmpRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpServiceTest {

	@Resource
	EmpService empService;
	
	@MockBean
	EmpRepository empRepository;

	private Employee returnEmployee;
	
	@Before
	public void setup() {
		returnEmployee = new Employee();
		returnEmployee.setEmpNo("1");
		returnEmployee.setEmpName("doni");
		returnEmployee.setSal(1000);
		when(empRepository.findById(anyString())).thenReturn(Optional.of(returnEmployee));
	}
	

	@Test
	public void testFindById() {
		Employee employee = empService.findById("1");
		
		assertEquals(returnEmployee, employee);
		verify(empRepository, times(1)).findById(anyString());
	}

}
