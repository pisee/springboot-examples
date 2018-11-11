package com.doni.springboot.examples.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.doni.springboot.examples.domain.Employee;
import com.doni.springboot.examples.repository.EmpRepository;

@Service
public class EmpService {

	@Resource
	EmpRepository empRepository;
	
	public Employee findById(String empNo) {
		Employee employee = empRepository.findById(empNo).orElse(new Employee());
		return employee;
	}

	public Employee save(Employee employee) {
		return empRepository.save(employee);
	}
}
