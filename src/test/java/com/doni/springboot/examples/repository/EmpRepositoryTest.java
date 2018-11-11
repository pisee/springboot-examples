package com.doni.springboot.examples.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.doni.springboot.examples.domain.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpRepositoryTest {

	@Resource
	EmpRepository repository;
	
	@Test
	public void find() {
		List<Employee> findAll = (List<Employee>) repository.findAll();
		System.out.println("findAll= " + findAll.size());
	}

	
	@Test
	public void save() {
		Employee emp = new Employee();
		emp.setEmpNo("1");
		emp.setEmpName("empName");
		emp.setSal(1000);
		Employee save = repository.save(emp );
		System.out.println("save=" + save);
		
		Employee employee = repository.findById("1").get();
		System.out.println("findByID=" + employee);
		
		assertEquals(save, emp);
		assertEquals(employee, emp);
	}
}
