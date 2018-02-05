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
	
	//나라 전체조회하는 매서드
	public List<Country> selectCountryList() {
		return sqlSessionTemplate.selectList(str+"selectCountryList");
	}
	
	//나라 하나 조회하는 매서드
	public Country selectCountryById(int countryId) {
		return sqlSessionTemplate.selectOne(str+"selectCountryById",countryId);
	}
	
	//나라 추가하는 매서드
	public int insertCountry(Country country) {
		return sqlSessionTemplate.insert(str+"insertCountry",country);
	}
	
	//나라 수정하는 매서드
	public int updateCountry(Country country) {
		return sqlSessionTemplate.update(str+"updateCountry",country);
	}
	
	public int deleteCountry(int countryId) {
		return sqlSessionTemplate.delete(str+"deleteCountry",countryId);
	}
}
