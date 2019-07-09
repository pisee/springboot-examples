package com.doni.springboot.examples.persistence.jpa.relation.onetoone.twoway;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Wife {

	@Id
	private String wifeId;
	private String wifeName;
	
	@OneToOne(mappedBy="wife")
	private Husband husband;	
}
