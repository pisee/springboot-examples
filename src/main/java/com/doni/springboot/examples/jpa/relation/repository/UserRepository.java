package com.doni.springboot.examples.jpa.relation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doni.springboot.examples.jpa.relation.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
