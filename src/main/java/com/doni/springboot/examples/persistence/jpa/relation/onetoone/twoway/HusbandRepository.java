package com.doni.springboot.examples.persistence.jpa.relation.onetoone.twoway;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value="husbandRepository2")
public interface HusbandRepository extends CrudRepository<Husband, String>{

}
