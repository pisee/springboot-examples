package com.doni.springboot.examples.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.doni.springboot.examples.domain.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"h2"})
public class EmpRepositoryTest {

	@Resource
	EmpRepository repository;
	
	@Test
	public void find() {
		List<Employee> findAll = (List<Employee>) repository.findAll();
		System.out.println("findAll= " + findAll.size());
	}

	@Test
	@Transactional
	public void findById() {
		String empNo = "1";
		Employee employee1 = repository.findById(empNo).orElse(null);
		Employee employee2 = repository.findById(empNo).orElse(null);
		
		System.out.println(employee1==employee2);
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
	
	@Test
//	@Transactional
//	@Rollback(false)
	public void saveone() {
		Employee emp = new Employee();
		emp.setEmpNo("002");
		emp.setEmpName("batman");
		emp.setSal(1000);
		Employee save = repository.save(emp );
		assertNotNull(save);
	}
}
