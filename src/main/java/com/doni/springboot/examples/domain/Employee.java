package com.doni.springboot.examples.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity

public class Employee {

	@Id
	private String empNo;
	private String empName;
	private int sal;
	
	
}
