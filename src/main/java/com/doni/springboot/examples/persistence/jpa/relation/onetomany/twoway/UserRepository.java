package com.doni.springboot.examples.persistence.jpa.relation.onetomany.twoway;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
