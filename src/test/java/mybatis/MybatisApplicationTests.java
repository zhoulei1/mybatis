package mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mybatis.mapper.CityMapper;
import mybatis.model.City;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class MybatisApplicationTests {
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void selectBySql() {
		System.out.println("");
		SqlSession session = sqlSessionFactory.openSession();
		try {
		  CityMapper cityMapper = session.getMapper(CityMapper.class);
		  System.out.println(cityMapper.selectCityById(1));
		  // 此种不推荐
		  //System.out.println((City)session.selectOne("mybatis.mapper.CityMapper.selectCityById", 1));
		} finally {
		  session.close();
		}
	}

}
