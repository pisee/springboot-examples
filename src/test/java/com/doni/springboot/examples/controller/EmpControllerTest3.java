package com.doni.springboot.examples.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("h2")
public class EmpControllerTest3 {

	@Autowired
    MockMvc mockMvc;
	
	@Test
	public void test() throws Exception {

		mockMvc.perform(get("/api/employees/result/1"))
			.andExpect(status().isOk())
//			.andExpect(content().json("{\"errorCode\":200,\"errorMessage\":\"success\",\"result\":{\"empNo\":\"1\",\"empName\":\"empName\",\"sal\":1000}}"))
			.andExpect(jsonPath("$.result.empNo").value("1"))
			;
	}
}
