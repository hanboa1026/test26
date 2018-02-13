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
public class CityService {
	@Autowired
	private CityDao cityDao;
	private static final Logger logger = LoggerFactory.getLogger(CityService.class);
	// 도시 조회(페이징)
	public Map<String, Object> selectCityListAndCountByPage(int currentPage, int pagePerRow) {
		logger.debug("{} : <- currentPage cityService.java", currentPage);
		logger.debug("{} : <- pagePerRow cityService.java", pagePerRow);
		int startPage = 0;
		if(currentPage > 1) {
			startPage = (currentPage-1)*pagePerRow;
		}
		// DAO에 시작 페이지와 행의 수 보내기
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startPage", startPage);
		map.put("pagePerRow", pagePerRow);
		List<City> list = cityDao.selectCityListByPage(map);
		logger.debug("{} : <- list cityService.java", list);
		// 총 행의 수를 보여줄 행의 수로 나눈 뒤 나머지가 0일 경우는 넘어가고 아닐 경우 +1 한다.
		int count = cityDao.selectCityCountByPage();
		logger.debug("{} : <- count cityService.java", count);
		int countPage = count/pagePerRow;
		if(count%pagePerRow != 0) {
			countPage++;
		}
		logger.debug("{} : >countPage cityService.java", countPage);
		// list, 페이지 수 리턴
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("countPage", countPage);
		return returnMap;
		}
	// 도시 전체 조회
		public List<City> selectCityList() {
			return cityDao.selectCityList();
		}
	// 업데이트 정보요청
	public City updateGetCity(int cityId) {
		City city = cityDao.updateGetCity(cityId);
		return city;
	}
	// 업데이트
	public int updateCity(City city) {
		int cityOne = cityDao.updateCity(city);
		return cityOne;
	}
	// 삭제
	public int deleteCity(int cityId) {
		int cityOne = cityDao.deleteCity(cityId);
		return cityOne;
	}
	// 등록
	public int insertCity(City city) {
		int cityOne = cityDao.insertCity(city);
		return cityOne;
	}
}
