package com.doni.springboot.examples.employee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Result<T> {
	private int errorCode = 200;
	private String errorMessage = "success";
	
	private T result;
}
