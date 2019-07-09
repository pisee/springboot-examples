package com.doni.springboot.examples.persistence.jpa.relation.onetoone.oneway;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value="wifeRepository1")
public interface WifeRepository extends CrudRepository<Wife, String>{

}
