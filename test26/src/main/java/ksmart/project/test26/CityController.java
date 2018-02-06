package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.City;
import ksmart.project.test26.service.CityDao;

@Controller
public class CityController {
	@Autowired
	private CityDao cityDao;
	
	// 목록조회
	@RequestMapping(value="/city/cityList", method=RequestMethod.GET)
	public String cityList(Model model) {
		List<City> list = cityDao.selectCityList();
		model.addAttribute("list", list);
		return "city/cityList";
	}
	
	// 입력페이지 요청
	@RequestMapping(value="/city/cityInsert", method=RequestMethod.GET)
	public String cityInsert() {
		return "city/cityInsert";
	}
	
	// 입력 처리요청
	@RequestMapping(value="/city/cityInsert", method=RequestMethod.POST)
	public String cityInsert(City city) {
		cityDao.insertCity(city);
		return "redirect:/city/cityList";
	}
	
	// 업데이트 정보요청
	@RequestMapping(value="/city/cityUpdate", method=RequestMethod.GET)
	public String cityUpdate(Model model, @RequestParam(value="cityId", required=true) int cityId) {
		City city = cityDao.updateGetCity(cityId);
		model.addAttribute("city", city);
		return "city/cityUpdate";
	}
	
	// 업데이트 처리요청
	@RequestMapping(value="/city/cityUpdate", method=RequestMethod.POST)
	public String cityUpdate(City city) {
		cityDao.updateCity(city);
		return "redirect:/city/cityList";
	}
	
	// 삭제
	@RequestMapping(value="/city/cityDelete", method=RequestMethod.GET)
	public String cityDelete(@RequestParam(value="cityId", required=true) int cityId) {
		cityDao.deleteCity(cityId);
		return "redirect:/city/cityList";
	}
}
