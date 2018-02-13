package ksmart.project.test26.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CountryService {
	
	private static final Logger logger = LoggerFactory.getLogger(CountryService.class);

	@Autowired
	private CountryDao countryDao;
	
	// 목록조회
	public List<Country> selectCountryList(int currentPage, int pagePerRow,String searchOption, String keyword){
		logger.debug("현재 페이지 {}번",currentPage);
		logger.debug("목록 수 {}개",pagePerRow);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("beginRow", (currentPage-1)*pagePerRow);
		//beginRow = (1-1)*10 = 0
		map.put("pagePerRow", pagePerRow);
		//LIMIT (beginRow)0,(pagePerRow)10 : 0번째부터 10번째까지
		logger.debug("CountryService 검색조건 : {}",searchOption);
		logger.debug("CountryService 검색어 : {}",keyword);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		List<Country> list = countryDao.selectCountryList(map);
		logger.debug("CountryService 검색후 나라 목록 : {}",list);
		
		return list;
	}
	
	// 총목록수조회
	public int getCountryCount(String searchOption, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		int count = countryDao.getCountryCount(map);
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
