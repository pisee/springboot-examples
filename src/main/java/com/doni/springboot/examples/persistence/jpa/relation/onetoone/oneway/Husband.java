package com.doni.springboot.examples.persistence.jpa.relation.onetoone.oneway;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Husband {
	
	@Id 
	private String husbandId;
	private String husbandName;
	
	@OneToOne
	@JoinColumn(name="wife_id")
	private Wife wife;
}
