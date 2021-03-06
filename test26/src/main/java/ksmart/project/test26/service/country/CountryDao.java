package ksmart.project.test26.service.country;

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
	// 마지막 id 조회
		public int selectLastId() {
			int selectLastId = sqlSessionTemplate.selectOne(localName+"selectLastId");
			logger.debug("selectLastId() 매서드  -- lastId is {}", selectLastId);
			return selectLastId;
	}
	// 파일 업로드
	public void insertCountryFile(CountryFile countryFile) {
		logger.debug("insertCountryFile(CountryFile countryFile) 메서드 countryFile is {}",countryFile);
		sqlSessionTemplate.insert(localName+"insertCountryFile", countryFile);
	}
	//파일목록조회
	public CountryAndCountryFile selectCountryAndCountryFile(int countryId) {
		logger.debug("selectCountryAndCountryFileList(int countryId) 메서드 countryId is {}",countryId);
		return sqlSessionTemplate.selectOne(localName+"selectCountryAndCountryFile", countryId);
	}
}
