package com.doni.springboot.examples.persistence.jpa.relation.onetomany.oneway2;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Child {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger childId;
	
	private String childName;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="parent_id")
	private Parent parent;
}
