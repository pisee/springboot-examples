package com.doni.springboot.examples.persistence.mybatis.annotation.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.doni.springboot.examples.persistence.mybatis.annotation.mapper.CityMapper;
import com.doni.springboot.examples.persistence.mybatis.domain.City;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@SpringBootTest
@ActiveProfiles({"h2"})
public class CityMapperTest {

  @Autowired
  CityMapper cityMapper;

  @Test
  public void findByStateTest() {
      City city = cityMapper.findByState("CA");
      assertThat(city.getName()).isEqualTo("San Francisco");
      assertThat(city.getState()).isEqualTo("CA");
      assertThat(city.getCountry()).isEqualTo("US");
  }
}

