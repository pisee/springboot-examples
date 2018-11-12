package com.doni.springboot.examples.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Result<T> {
	private int errorCode = 200;
	private String errorMessage = "success";
	
	private T result;
}
