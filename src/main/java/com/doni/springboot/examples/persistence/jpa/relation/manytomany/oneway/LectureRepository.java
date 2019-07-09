package com.doni.springboot.examples.persistence.jpa.relation.manytomany.oneway;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value="lectureRepository1")
public interface LectureRepository extends CrudRepository<Lecture, String>{

}
