package com.doni.springboot.examples.persistence.jpa.relation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doni.springboot.examples.persistence.jpa.relation.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
