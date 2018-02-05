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

	public List<Country> selectCountryList() {
		return sqlSessionTemplate.selectList(str+"selectCountryList");
	}
	
	public int insertCountry(Country country) {
		return sqlSessionTemplate.insert(str+"insertCountry",country);
	}
}
