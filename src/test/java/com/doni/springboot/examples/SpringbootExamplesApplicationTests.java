package com.doni.springboot.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.condition.ParamsRequestCondition;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootExamplesApplicationTests {

	@Resource
	ApplicationContext context;
	
	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;

	
	@Test
	public void contextLoads() {
	}

	@Test
	public void getHandlerMappingInfo() {
		Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
		StringBuilder sb = new StringBuilder();
		for (RequestMappingInfo keys : map.keySet()) {
			sb.append(map.get(keys).getShortLogMessage()).append(" ").append(keys.getPatternsCondition()).append(" ")
					.append(keys.getMethodsCondition()).append("\n");
			
		}
		System.out.println(sb.toString());
	}
}
