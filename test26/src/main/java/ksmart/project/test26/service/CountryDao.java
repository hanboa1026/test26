package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDao {
	private String str = "ksmart.project.test26.service.countryMapper.";	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;	
	// 목록조회
	public List<Country> selectCountryList() {
		return sqlSessionTemplate.selectList(str+"selectCountryList");
	}	
	// 업데이트 정보요청
	public Country selectCountryById(int countryId) {
		return sqlSessionTemplate.selectOne(str+"selectCountryById",countryId);
	}	
	// 업데이트
	public int updateCountry(Country country) {
		return sqlSessionTemplate.update(str+"updateCountry",country);
	}
	// 삭제
	public int deleteCountry(int countryId) {
		return sqlSessionTemplate.delete(str+"deleteCountry",countryId);
	}
	// 등록
	public int insertCountry(Country country) {
		return sqlSessionTemplate.insert(str+"insertCountry",country);
	}	
}
