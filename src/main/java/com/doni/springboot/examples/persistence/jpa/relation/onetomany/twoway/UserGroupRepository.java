package com.doni.springboot.examples.persistence.jpa.relation.onetomany.twoway;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupRepository extends CrudRepository<UserGroup, String>{

}
