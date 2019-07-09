package com.doni.springboot.examples.persistence.jpa.relation.manytomany.twoway;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Lecture {

	@Id
	private String lectureId;
	private String lectureTitle;
	
	@ManyToMany(mappedBy="lectures")
	private List<Student> students;
}
