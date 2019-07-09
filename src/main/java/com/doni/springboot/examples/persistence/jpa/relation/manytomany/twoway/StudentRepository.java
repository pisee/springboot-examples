package com.doni.springboot.examples.persistence.jpa.relation.manytomany.twoway;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value="studentRepository2")
public interface StudentRepository extends CrudRepository<Student, String>{

}
