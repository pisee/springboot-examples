package com.doni.springboot.examples.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.doni.springboot.examples.domain.Result;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("h2")
public class EmpControllerTest5 {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

	@Test
	public void test() throws Exception {
//		Result result = restTemplate.getForObject("http://localhost:" + port + "/api/employees/result/1", Result.class);
		
		
		ResponseEntity<Result> forEntity = restTemplate.getForEntity("http://localhost:"+port+"/api/employees/result/1", Result.class);
		Result result = forEntity.getBody();
		
		System.out.println(result);
	}
}
