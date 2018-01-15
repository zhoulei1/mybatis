package mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import mybatis.model.City;

//@Mapper
public interface CityMapper {

	/**
	 *注解
	 */
	@Select("select * from city where state = #{state}")
	City findByState(@Param("state") String state);
	
	/**xml 
	 */
	City selectCityById(int city_id);
	
	int insert(City city);

}
