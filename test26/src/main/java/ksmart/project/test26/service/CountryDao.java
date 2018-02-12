package ksmart.project.test26.service;

import java.util.HashMap;
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
	public List<Country> selectCountryList(Map<String, Integer> map, int currentPage, int pagePerRow) {
		/*logger.debug("현재 페이지 {}번",currentPage);
		logger.debug("목록 수 {}개",pagePerRow);
		map.put("beginRow", (currentPage-1)*pagePerRow);
		//beginRow = 0 = (1-1)*10 = 0
		map.put("pagePerRow", pagePerRow);
		//LIMIT 0,10 : 0번째부터 10번째까지
*/		return sqlSessionTemplate.selectList(localName+"selectCountryList",map);
	}
	// 총목록수조회
	public int getCountryCount() {
		return sqlSessionTemplate.selectOne(localName+"getCountryCount");
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
