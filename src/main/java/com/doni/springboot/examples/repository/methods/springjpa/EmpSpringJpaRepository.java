package com.doni.springboot.examples.repository.methods.springjpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.doni.springboot.examples.domain.Employee;

@Repository
public interface EmpSpringJpaRepository extends CrudRepository<Employee, String> {
	
	Employee findByEmpNo(String empNo);
	
	@Query(value="SELECT emp_no, emp_name, sal FROM EMP WHERE emp_no=?1", nativeQuery=true)
	Employee getEmployeeUsingQuery(String empNo);
	
	@Query(value="SELECT emp_no, emp_name, sal FROM EMP WHERE emp_no=:empNo", nativeQuery=true)
	Employee getEmployeeUsingQueryWithNameParam(@Param("empNo") String empNo);

	@Query(value="SELECT e FROM Employee e WHERE empNo=?1", nativeQuery=false)
	Employee getEmployeeUsingJpql(String empNo);
	
//	List<Employee> getEmployeeQueryByEmpNo(@Param("empNo")String empNo);
	Employee getEmployeeQueryByEmpNo(@Param("empNo")String empNo);
	
//	List<Employee> getEmployeeNativeQueryByEmpNo(@Param("empNo")String empNo);
	Employee getEmployeeNativeQueryByEmpNo(@Param("empNo")String empNo);
}
