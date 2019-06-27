package com.doni.springboot.examples.employee.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.doni.springboot.examples.employee.controller.EmpController;
import com.doni.springboot.examples.employee.domain.Employee;
import com.doni.springboot.examples.employee.service.EmpService;

@RunWith(SpringRunner.class)
@WebMvcTest(EmpController.class)
public class EmpControllerTest4 {

	@Autowired
    MockMvc mockMvc;
	
	@MockBean
	EmpService empService;
	
	@Test
	public void test() throws Exception {

		Employee newEmployee = new Employee();
		newEmployee.setEmpNo("1");
		newEmployee.setEmpName("mock");
		newEmployee.setSal(10000);
		when(empService.findById("1")).thenReturn(newEmployee );

		
		mockMvc.perform(get("/api/employees/result/1"))
			.andExpect(status().isOk())
//			.andExpect(content().json("{\"errorCode\":200,\"errorMessage\":\"success\",\"result\":{\"empNo\":\"1\",\"empName\":\"empName\",\"sal\":1000}}"))
			.andExpect(jsonPath("$.result.empNo").value("1"))
			;
	}
}
