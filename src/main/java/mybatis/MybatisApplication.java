package mybatis;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import mybatis.model.City;
//DataSourceAutoConfiguration 自动配置spring.datasource.*数据源(,会生成DataSource,不进行装配)
//exclude 不生效?!!!!
@SpringBootApplication
public class MybatisApplication {
	public static void main(String[] args) throws Exception {
		 SpringApplication.run(MybatisApplication.class, args);
	}
}
