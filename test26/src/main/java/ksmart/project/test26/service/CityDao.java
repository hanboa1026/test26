package ksmart.project.test26.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	String localName = "ksmart.project.test26.mapper.CityMapper.";
	private static final Logger logger = LoggerFactory.getLogger(CityDao.class);
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
	// 전체 도시 수(페이징)
	public int selectCityCountByPage() {
		logger.debug("<selectCityCountByPage CityDao");
		return sqlSessionTemplate.selectOne(localName+"selectCityCountByPage");
	}
		
	// 도시 조회(페이징)
	public List<City> selectCityListByPage(Map map) {
		logger.debug("{} : <- startPage CityDao.java", map.get("startPage"));
		logger.debug("{} : <- pagePerRow CityDao.java", map.get("pagePerRow"));
		return sqlSessionTemplate.selectList(localName+"selectCityListByPage", map);
		}
}
