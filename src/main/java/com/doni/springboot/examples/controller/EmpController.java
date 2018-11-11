package com.doni.springboot.examples.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doni.springboot.examples.domain.Employee;
import com.doni.springboot.examples.exception.ForbiddenException;
import com.doni.springboot.examples.service.EmpService;

@RestController
@RequestMapping("/api/employees")
public class EmpController {

	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	@Resource
	EmpService empService;
	
	@GetMapping("/{empNo}")
	public Employee findbyId(@PathVariable String empNo) {
		logger.debug("empNo : "+ empNo);
		return empService.findById(empNo); 
	}

	@GetMapping("/head/{empNo}")
	public ResponseEntity<Employee> findbyIdWithHead(@PathVariable String empNo) {
		logger.debug("empNo : "+ empNo);
		Employee employee = empService.findById(empNo); 
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("hello", "world");
		httpHeaders.add("x_doni","hi doni");

		return new ResponseEntity<Employee>(employee, httpHeaders, HttpStatus.OK);
	}
	
	@GetMapping("/exception/{empNo}")
	public ResponseEntity<Employee> findbyIdWithException(@PathVariable String empNo) {
		logger.debug("empNo : "+ empNo);
		throw new ForbiddenException("ForbiddenException");
	}
	
	@ExceptionHandler(ForbiddenException.class)
	public ResponseEntity<Object> handleBadRequest(HttpServletRequest req, Exception ex) {
		return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT);
	}
	
	@PostMapping
	public Employee save(@RequestBody Employee employee) {
		logger.debug("employees : "+ employee);
		return empService.save(employee);
	}
	
}
