package ksmart.project.test26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CityService {
	@Autowired
	private CityDao cityDao;
	// 목록조회
		public List<City> selectCityList() {
			List<City> list = cityDao.selectCityList();
			return list;
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
