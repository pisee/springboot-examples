package com.doni.springboot.examples.persistence.jpa.relation.manytomany.twoway;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value="lectureRepository2")
public interface LectureRepository extends CrudRepository<Lecture, String>{

}
