package com.doni.springboot.examples.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doni.springboot.examples.employee.domain.Employee;

@Repository
public interface EmpRepository extends CrudRepository<Employee, String>{

}
