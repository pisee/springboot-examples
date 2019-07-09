package com.doni.springboot.examples.persistence.jpa.relation.onetoone.oneway;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Wife {

	@Id
	private String wifeId;
	private String wifeName;
}
