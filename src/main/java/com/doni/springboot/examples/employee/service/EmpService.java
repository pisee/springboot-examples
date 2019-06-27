package com.doni.springboot.examples.employee.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doni.springboot.examples.employee.domain.Employee;
import com.doni.springboot.examples.employee.exception.ForbiddenException;
import com.doni.springboot.examples.employee.repository.EmpRepository;

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
	
	public Employee update(Employee employee) {
		if(findById(employee.getEmpNo()) == null) {
			return null;			
		}else {
			return empRepository.save(employee);
		}
	}
	
	public Employee create(Employee employee) {
		if(findById(employee.getEmpNo()) == null) {
			return empRepository.save(employee);			
		}else {
			return null;
		}
	}
	@Transactional
	public Employee saveAndThrowException(Employee employee) {
		empRepository.save(employee);
		throw new ForbiddenException("ForbiddenException in employeeService");
	}
}
