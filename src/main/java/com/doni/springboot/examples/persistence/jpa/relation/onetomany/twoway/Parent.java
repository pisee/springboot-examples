package com.doni.springboot.examples.persistence.jpa.relation.onetomany.twoway;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Parent {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger parentId;
	
	private String motherName;
	private String fatherName;
	
	@OneToMany(mappedBy="parent", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Child> childs;
}
