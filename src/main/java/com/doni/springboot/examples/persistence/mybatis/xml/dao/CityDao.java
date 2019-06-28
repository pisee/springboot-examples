package com.doni.springboot.examples.persistence.mybatis.xml.dao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.doni.springboot.examples.persistence.mybatis.domain.City;

/**
 * @author Eddú Meléndez
 */
@Repository
public class CityDao {

  private final SqlSession sqlSession;

  public CityDao(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  public City selectCityById(long id) {
    return this.sqlSession.selectOne("selectCityById", id);
  }

}