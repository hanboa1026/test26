package ksmart.project.test26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CountryService {

	@Autowired
	private CountryDao countryDao;
	
	// 목록조회
	public List<Country> selectCountryList(){
		List<Country> list = countryDao.selectCountryList();
		return list;
	}
	
	// 입력처리서비스
	public int insertCountry(Country country) {
		int row = countryDao.insertCountry(country);
		return row;
	}
	
	// 하나정보받기
	public Country getCountry(int countryId) {
		Country one = countryDao.selectCountryById(countryId);
		return one;
	}
	
	// 업데이트
	public int updateCountry(Country country) {
		int row = countryDao.updateCountry(country);
		return row;
	}
	
	// 삭제
	public int deleteCountry(int countryId) {
		int row = countryDao.deleteCountry(countryId);
		return row;
	}
}
