package com.doni.springboot.examples.persistence.jpa.relation.onetomany.oneway1;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value="parentRepository1")
public interface ParentRepository extends CrudRepository<Parent, BigInteger>{

}
