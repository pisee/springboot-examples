package com.doni.springboot.examples.persistence.jpa.relation.onetomany.oneway2;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value="parentRepository2")
public interface ParentRepository extends CrudRepository<Parent, BigInteger>{

}
