package com.doni.springboot.examples.persistence.jpa.relation.manytomany.oneway;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Lecture {

	@Id
	private String lectureId;
	private String lectureTitle;
}
