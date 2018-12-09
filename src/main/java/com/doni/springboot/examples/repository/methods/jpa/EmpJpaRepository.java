package com.doni.springboot.examples.repository.methods.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.doni.springboot.examples.domain.Employee;

@Repository
public class EmpJpaRepository {

	@PersistenceContext
	EntityManager em;
	
	public Employee getEmployeeByEmpNo(String empNo) {
		
		Employee employee = em.find(Employee.class, empNo);
		return employee;
	}
}
