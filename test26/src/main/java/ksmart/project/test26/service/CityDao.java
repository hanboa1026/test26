package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	String localName = "ksmart.project.test26.service.cityMapper.";
	// 목록조회
	public List<City> selectCityList() {
		return sqlSessionTemplate.selectList(localName+"selectCityList");
	}
	// 업데이트 정보요청
	public City updateGetCity(int cityId) {
		return sqlSessionTemplate.selectOne(localName+"getCity", cityId);
	}
	// 업데이트
	public int updateCity(City city) {
		return sqlSessionTemplate.update(localName+"updateCity", city);
	}
	// 삭제
	public int deleteCity(int cityId) {
		return sqlSessionTemplate.delete(localName+"deleteCity", cityId);
	}
	// 등록
	public int insertCity(City city) {
		return sqlSessionTemplate.insert(localName+"insertCity", city);
	}
}
