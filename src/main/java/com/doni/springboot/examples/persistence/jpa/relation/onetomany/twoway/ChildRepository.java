package com.doni.springboot.examples.persistence.jpa.relation.onetomany.twoway;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value="childRepository3")
public interface ChildRepository extends CrudRepository<Child, BigInteger>{

}
