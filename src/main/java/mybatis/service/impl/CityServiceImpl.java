package mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mybatis.mapper.CityMapper;
import mybatis.model.City;
import mybatis.service.CityService;

@Service
public class CityServiceImpl implements CityService {
	@Autowired
	CityMapper cityMapper;
	
	@Transactional
	@Override
	public int add(City city) {
		int insert = cityMapper.insert(city);
	//	int i=1/0;
		return insert;
	}
}
