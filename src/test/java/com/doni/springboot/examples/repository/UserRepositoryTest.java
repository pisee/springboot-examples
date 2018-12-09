package com.doni.springboot.examples.repository;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.doni.springboot.examples.domain.Group;
import com.doni.springboot.examples.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("h2")
public class UserRepositoryTest {

	@Resource
	UserRepository userRepository;

	@Test
	public void save() {
		User user = new User();
		user.setUserId("1");
		user.setUserName("doni");
		
		Group group = new Group();
		group.setGroupId("1");
		group.setGroupName("doni group");
		user.setGroup(group);
		userRepository.save(user);
	}
	
	@Test
	public void find() {
		User user = userRepository.findById("1").orElse(null);
		System.out.println(user);
	}

}
