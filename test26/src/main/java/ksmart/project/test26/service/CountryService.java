package ksmart.project.test26.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CountryService {

	@Autowired
	private CountryDao countryDao;
	
	// 목록조회
	public List<Country> selectCountryList(int currentPage, int pagePerRow){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRow", (currentPage-1)*pagePerRow);
		//beginRow = 0 = (1-1)*10 = 0
		map.put("pagePerRow", pagePerRow);
		List<Country> list = countryDao.selectCountryList(map, pagePerRow, pagePerRow);
		
		return list;
	}
	
	// 총목록수조회
	public int getCountryCount() {
		int count = countryDao.getCountryCount();
		return count;
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
