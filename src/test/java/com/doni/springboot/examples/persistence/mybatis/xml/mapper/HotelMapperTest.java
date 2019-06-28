package com.doni.springboot.examples.persistence.mybatis.xml.mapper;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.doni.springboot.examples.persistence.mybatis.domain.Hotel;
import com.doni.springboot.examples.persistence.mybatis.xml.mapper.HotelMapper;

/**
 * Tests for {@link HotelMapper}.
 * 
 * @author wonwoo
 * @since 1.2.1
 */
@RunWith(SpringRunner.class)
//@MybatisTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
@ActiveProfiles({"h2"})
public class HotelMapperTest {

  @Autowired
  private HotelMapper hotelMapper;

  @Test
  public void selectByCityIdTest() {
    Hotel hotel = hotelMapper.selectByCityId(1);
    assertThat(hotel.getCity()).isEqualTo(1);
    assertThat(hotel.getName()).isEqualTo("Conrad Treasury Place");
    assertThat(hotel.getAddress()).isEqualTo("William & George Streets");
    assertThat(hotel.getZip()).isEqualTo("4001");
  }

}