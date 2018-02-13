package ksmart.project.test26.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDao {
	
	 private static final Logger logger = LoggerFactory.getLogger(CountryDao.class);
	 
	private String localName = "ksmart.project.test26.mapper.CountryMapper.";	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;	
	
	// 목록조회
	public List<Country> selectCountryList(Map<String, Object> map) {
		return sqlSessionTemplate.selectList(localName+"selectCountryList",map);
	}
	// 목록수조회
	public int getCountryCount(Map<String, Object> map) {
		return sqlSessionTemplate.selectOne(localName+"getCountryCount",map);
	}
	// 업데이트 정보요청
	public Country selectCountryById(int countryId) {
		logger.debug("나라 번호 {}번",countryId);
		return sqlSessionTemplate.selectOne(localName+"selectCountryById",countryId);
	}	
	// 업데이트
	public int updateCountry(Country country) {
		logger.debug("나라 정보 {}",country);
		return sqlSessionTemplate.update(localName+"updateCountry",country);
	}
	// 삭제
	public int deleteCountry(int countryId) {
		logger.debug("나라 번호 {}번",countryId);		
		return sqlSessionTemplate.delete(localName+"deleteCountry",countryId);
	}
	// 등록
	public int insertCountry(Country country) {
		logger.debug("나라 정보 {}",country);
		return sqlSessionTemplate.insert(localName+"insertCountry",country);
	}

}
