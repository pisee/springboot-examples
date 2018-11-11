package com.doni.springboot.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootExamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootExamplesApplication.class, args);
		
//		SpringApplication application = new SpringApplication(SpringBootApplication.class);
//		application.setBanner(new Banner() {
//			
//			@Override
//			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
//				out.println("doni springboot examples");
//				
//			}
//		});
//		application.run(args);
	}
}
