package mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//DataSourceAutoConfiguration 自动配置spring.datasource.*数据源(,会生成DataSource,不进行装配)
//exclude 不生效?!!!!
@SpringBootApplication
public class MybatisApplication {
	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}
}
