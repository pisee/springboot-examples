package com.doni.springboot.examples.persistence.jpa.relation.manytomany.oneway;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value="studentRepository1")
public interface StudentRepository extends CrudRepository<Student, String>{

}
