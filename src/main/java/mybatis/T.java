package mybatis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.model.City;

public class T {

	public static void main(String[] args) {
		SqlSession session = null;
		try {
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsReader("mybatis-config.xml"));
			session = sqlSessionFactory.openSession(ExecutorType.BATCH);
			List<City> list = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				list.add(new City(i + "", "", ""));
				// 添加一个错误
				if (i == 5) {
					list.add(new City(null, "", ""));
				}
			}
			// 批量添加，一次添加2个
			int i = 0;
			while (i < list.size()) {
				int end = Math.min(i + 2, list.size());
				List<City> subList=null;
				try {
					subList = list.subList(i, end);
					for (City city : subList) {
						session.insert("insert", city);
					}
					session.commit();
				} catch (Exception e) {
					for (City city : subList) {
						System.out.println("uninsert : "+city.getName());
					}
					session.rollback();
				}
				i = end;
			}
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
	}

}
