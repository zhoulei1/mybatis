package mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import mybatis.mapper.CityMapper;
import mybatis.mapper.HotelMapper;
import mybatis.model.City;
import mybatis.service.CityService;
//DataSourceAutoConfiguration 自动配置spring.datasource.*数据源(,会生成DataSource,不进行装配)
//exclude 不生效?!!!!
@SpringBootApplication(scanBasePackages={ "mybatis" },exclude = {DataSourceAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class})
public class MybatisApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(MybatisApplication.class, args);
		CityMapper cityMapper = run.getBean(CityMapper.class);
		System.out.println(cityMapper.findByState("CA"));
		System.out.println(cityMapper.selectCityById(1));
		
		HotelMapper hotelMapper = run.getBean(HotelMapper.class);
		System.out.println(hotelMapper.selectByCityId(1));
		
		CityService cityService = run.getBean(CityService.class);
		try {
			City vo =  new City("WuHan", "Hu", "CN");
			System.out.println(cityService.add(vo));
			
		} catch (Exception e) {
			System.out.println(cityMapper.findByState("Hu"));
		}
		
		
		
		
	}
}
