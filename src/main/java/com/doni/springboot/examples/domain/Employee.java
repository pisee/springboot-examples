package com.doni.springboot.examples.domain;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="EMP")
//@Document(collection="EMP")
@NamedQuery(
	name= "Employee.getEmployeeQueryByEmpNo",
	query="SELECT e FROM Employee e WHERE empNo=:empNo")
@SqlResultSetMapping(name = "EmployeeResult", classes = {
		@ConstructorResult(targetClass = Employee.class, columns = {
				@ColumnResult(name = "emp_no", type = String.class), 
				@ColumnResult(name = "emp_name", type = String.class),
				@ColumnResult(name = "sal", type = Integer.class) }) })
@NamedNativeQuery(
	name= "Employee.getEmployeeNativeQueryByEmpNo",
	query="SELECT emp_no, emp_name, sal FROM EMP WHERE emp_no=:empNo",
	resultSetMapping = "EmployeeResult")
public class Employee {

	@Id
	private String empNo;
	private String empName;
	private int sal;
	
	
}
