package com.doni.springboot.examples.persistence.jpa.relation.onetomany.twoway;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.doni.springboot.examples.persistence.jpa.relation.onetomany.twoway.User;
import com.doni.springboot.examples.persistence.jpa.relation.onetomany.twoway.UserGroup;
import com.doni.springboot.examples.persistence.jpa.relation.onetomany.twoway.UserGroupRepository;
import com.doni.springboot.examples.persistence.jpa.relation.onetomany.twoway.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("h2")
public class UserRepositoryTest {

	@Resource
	UserRepository userRepository;
	
	@Resource
	UserGroupRepository userGroupRepository;

	UserGroup group;
	User user;

	@Before
	public void setup() {
		group = new UserGroup();
		group.setGroupId("g1");
		group.setGroupName("doni group");
		
		user = new User();
		user.setUserId("u1");
		user.setUserName("doni");

		List<UserGroup> userGroup = new ArrayList<UserGroup>();
		userGroup.add(group);

		user.setUserGroups(userGroup);
	}
	
	@Test
	public void save() {
		group.setUser(user);
		userGroupRepository.save(group);
		
		userRepository.save(user);
	}
	
	@Test
	@Transactional
	public void find() {
		User resultUser = userRepository.findById("u1").orElse(null);
		
		System.out.println("=========" + resultUser);
		
		assertEquals(user.getUserId(), resultUser.getUserId());
		assertEquals(user.getUserGroups().get(0).getGroupId(), resultUser.getUserGroups().get(0).getGroupId());
	}

}
