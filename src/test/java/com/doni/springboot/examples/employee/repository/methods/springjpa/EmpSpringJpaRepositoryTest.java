package com.doni.springboot.examples.employee.repository.methods.springjpa;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.doni.springboot.examples.employee.domain.Employee;
import com.doni.springboot.examples.employee.repository.methods.springjpa.EmpSpringJpaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"h2"})
public class EmpSpringJpaRepositoryTest {

	@Resource
	EmpSpringJpaRepository empSpringJpaRepository;
	
	@Test
	@Transactional
	public void test() {
		String empNo = "1";
		Employee employee1 = empSpringJpaRepository.findById(empNo).orElse(null);
		Employee employee2 = empSpringJpaRepository.findByEmpNo(empNo);
				
//		employees = (List<Employee>)empSpringJpaRepository.getEmployeeQueryByEmpNo(empNo);
//		Employee employee3 = employees.get(0);
		Employee employee3 = empSpringJpaRepository.getEmployeeQueryByEmpNo(empNo);

		Employee employee4 = empSpringJpaRepository.getEmployeeUsingJpql(empNo);
		Employee employee5 = empSpringJpaRepository.getEmployeeUsingQuery(empNo);
		Employee employee6 = empSpringJpaRepository.getEmployeeUsingQueryWithNameParam(empNo);

//		List<Employee> employees = (List<Employee>)empSpringJpaRepository.getEmployeeNativeQueryByEmpNo(empNo);
//		Employee employee7 = employees.get(0);
		Employee employee7 = empSpringJpaRepository.getEmployeeNativeQueryByEmpNo(empNo);
		
		System.out.println(employee1);
		System.out.println(employee2);
		System.out.println(employee3);
		System.out.println(employee4);
		System.out.println(employee5);
		System.out.println(employee6);
		System.out.println(employee7);
		
		System.out.println((employee1==employee2) + "," 
				+ (employee1==employee3) + ","
				+ (employee1==employee4) + ","
				+ (employee1==employee5) + ","
				+ (employee1==employee6) + ","
				+ (employee1==employee7));
		System.out.println((employee2==employee3) + ","
				+ (employee2==employee4) + ","
				+ (employee2==employee5) + ","
				+ (employee2==employee6) + ","
				+ (employee2==employee7) + ",");
		System.out.println((employee3==employee4) + ","
				+ (employee3==employee5) + ","
				+ (employee3==employee6) + ","
				+ (employee3==employee7) + ",");
		System.out.println((employee4==employee5) + "," 
				+ (employee4==employee5) + ","
				+ (employee4==employee7) + ",");
		System.out.println((employee5==employee6) + ","
				+ (employee5==employee7) + ",");
		System.out.println(employee6==employee7);

		assertEquals(true, employee1.equals(employee2));
		assertEquals(true, employee2.equals(employee3));
		assertEquals(true, employee3.equals(employee4));
		assertEquals(true, employee4.equals(employee5));
		assertEquals(true, employee5.equals(employee6));
		assertEquals(true, employee6.equals(employee7));
		
//		assertEquals(true, employee1 == employee2);
//		assertEquals(true, employee2 == employee3);
//		assertEquals(true, employee3 == employee4);
//		assertEquals(true, employee4 == employee5);
//		assertEquals(true, employee5 == employee6);
//		assertEquals(true, employee6 == employee7);
	}

}
