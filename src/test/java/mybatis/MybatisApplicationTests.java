package mybatis;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import mybatis.mapper.CityMapper;
import mybatis.model.City;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MybatisApplicationTests {

	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void tt(){
		SqlSession session =null;
		CityMapper cityMapper = null;
		try {
			session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
			session.insert("insert",new City("ss", "ssss", ""));
			System.out.println(session.selectOne("count"));
/*			cityMapper = session.getMapper(CityMapper.class);
			System.out.println(cityMapper.count());
			cityMapper.insert(new City("ss", "ssss", ""));
			cityMapper.insert(new City(null, "ssss", ""));
			System.out.println(cityMapper.count());
			session.commit();*/
		} catch (Exception e1) {
			e1.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
}
