package com.doni.springboot.examples.persistence.jpa.relation.manytomany.twoway;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Student {

	@Id
	private String studentId;
	private String studentName;
	
	@ManyToMany
	@JoinTable(name="student_lecture",
				joinColumns = @JoinColumn(name = "student_id"),
				inverseJoinColumns = @JoinColumn(name = "lecture_id"))
	private List<Lecture> lectures;
}
