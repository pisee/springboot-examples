package com.doni.springboot.examples.persistence.jpa.relation.onetomany.twoway;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name = "user_id")
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userId;
	private String UserName;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<UserGroup> userGroups;
}
