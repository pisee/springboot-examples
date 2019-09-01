package com.doni.springboot.examples.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.doni.springboot.examples.employee.domain.Employee;

@Repository
public class EmpJdbcRepository {

	@Value(value = "${spring.datasource.driver-class-name}")
	private String JDBC_DRIVER = "org.h2.Driver";
	
	@Value(value = "${spring.datasource.url}")
	private String DB_URL = "jdbc:h2:file:~/data/springboot-examples-db";

	@Value(value = "${spring.datasource.username}")
	private String USER = "sa";

	@Value(value = "${spring.datasource.password}")
	private String PASS = "";

	public Employee getEmployeeByEmpNo(String empNo) {
		Employee employee = new Employee();

		try (
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement()
		){
			Class.forName(JDBC_DRIVER);
			
			String sql;
			sql = "SELECT emp_no, emp_name, sal FROM EMP WHERE emp_no=" + empNo;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				employee.setEmpNo(rs.getString("emp_no"));
				employee.setEmpName(rs.getString("emp_name"));
				employee.setSal(rs.getInt("sal"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return employee;
	}
}
