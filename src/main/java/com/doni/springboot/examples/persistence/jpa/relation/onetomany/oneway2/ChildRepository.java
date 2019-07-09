package com.doni.springboot.examples.persistence.jpa.relation.onetomany.oneway2;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value="childRepository2")
public interface ChildRepository extends CrudRepository<Child, BigInteger>{

}
