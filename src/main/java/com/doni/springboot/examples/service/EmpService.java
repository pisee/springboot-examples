package com.doni.springboot.examples.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doni.springboot.examples.domain.Employee;
import com.doni.springboot.examples.exception.ForbiddenException;
import com.doni.springboot.examples.repository.EmpRepository;

@Service
public class EmpService {

	@Resource
	EmpRepository empRepository;
	
	public Employee findById(String empNo) {
		Employee employee = empRepository.findById(empNo).orElse(null);
		return employee;
	}

	public Employee save(Employee employee) {
		return empRepository.save(employee);
	}
	
	@Transactional
	public Employee saveAndThrowException(Employee employee) {
		empRepository.save(employee);
		throw new ForbiddenException("ForbiddenException in employeeService");
	}
}
