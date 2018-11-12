package com.doni.springboot.examples.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doni.springboot.examples.domain.Employee;
import com.doni.springboot.examples.domain.Result;
import com.doni.springboot.examples.exception.ForbiddenException;
import com.doni.springboot.examples.service.EmpService;

@CrossOrigin
@RestController
@RequestMapping("/api/employees")
public class EmpController {

	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);

	private EmpService empService;
	
	public EmpController(EmpService empService) {
		super();
		this.empService = empService;
	}
	
//	@Autowired
//	public void setEmpService(EmpService empService) {
//		this.empService = empService;
//	}

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
	
	@GetMapping("/result/{empNo}")
	public Result<Employee> findbyIdWithresult(@PathVariable String empNo) {
		logger.debug("empNo : "+ empNo);
		Result<Employee> result = new Result<>();
		Employee employee = empService.findById(empNo);
		logger.debug("result:" + employee);
		if (employee == null) {
			result.setErrorCode(HttpStatus.NOT_FOUND.value());
			result.setErrorMessage("Not found.");
		}else {
			result.setResult(employee);
		}
		return result;
		
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
	
	@PostMapping("/exception")
	public Employee saveAndThrowException(@RequestBody Employee employee) {
		logger.debug("saveAndThrowException employees : "+ employee);
		return empService.saveAndThrowException(employee);
	}
	
}
