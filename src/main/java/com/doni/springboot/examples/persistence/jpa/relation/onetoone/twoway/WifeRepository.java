package com.doni.springboot.examples.persistence.jpa.relation.onetoone.twoway;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value="wifeRepository2")
public interface WifeRepository extends CrudRepository<Wife, String>{

}
