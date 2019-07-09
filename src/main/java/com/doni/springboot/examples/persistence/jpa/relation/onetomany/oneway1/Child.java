package com.doni.springboot.examples.persistence.jpa.relation.onetomany.oneway1;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Child {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger childId;
	
	private String childName;
	
}
