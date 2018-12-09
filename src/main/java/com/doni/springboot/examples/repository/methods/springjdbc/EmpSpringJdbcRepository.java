package com.doni.springboot.examples.repository.methods.springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.doni.springboot.examples.domain.Employee;

@Repository
public class EmpSpringJdbcRepository {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public Employee findbyId(String empNo) {
		String sql = "SELECT emp_no, emp_name, sal FROM EMP WHERE emp_no=?";
		
		return jdbcTemplate.queryForObject(sql, new Object[] { empNo },
			new RowMapper<Employee>(){  
			    @Override  
			    public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {  
			        Employee e=new Employee();  
			        e.setEmpNo(rs.getString("emp_no"));  
			        e.setEmpName(rs.getString("emp_name"));  
			        e.setSal(rs.getInt("sal"));  
			        return e;  
			    }
	    	}
		);
	}
}
