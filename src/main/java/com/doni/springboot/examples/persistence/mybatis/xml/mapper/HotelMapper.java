package com.doni.springboot.examples.persistence.mybatis.xml.mapper;
import org.apache.ibatis.annotations.Mapper;

import com.doni.springboot.examples.persistence.mybatis.domain.Hotel;

/**
 * @author Eduardo Macarron
 */
@Mapper
public interface HotelMapper {

  Hotel selectByCityId(int cityId);

}