package com.doni.springboot.examples.persistence.mybatis.xml.dao;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.doni.springboot.examples.persistence.mybatis.domain.City;
import com.doni.springboot.examples.persistence.mybatis.xml.dao.CityDao;

/**
 * Tests for {@link CityDao}.
 * 
 * @author wonwoo
 * @since 1.2.1
 */
@RunWith(SpringRunner.class)
//@MybatisTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
@ActiveProfiles({"h2"})
@Import(CityDao.class)
public class CityDaoTest {

  @Autowired
  private CityDao cityDao;

  @Test
  public void selectCityByIdTest() {
    City city = cityDao.selectCityById(1);
    assertThat(city.getId()).isEqualTo(1);
    assertThat(city.getName()).isEqualTo("San Francisco");
    assertThat(city.getState()).isEqualTo("CA");
    assertThat(city.getCountry()).isEqualTo("US");
  }

}