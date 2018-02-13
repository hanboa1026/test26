package ksmart.project.test26;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.City;
import ksmart.project.test26.service.CityService;

@Controller
public class CityController {
	@Autowired
	private CityService cityService;
	private static final Logger logger = LoggerFactory.getLogger(CityController.class);
	
	// 도시 조회(페이징)
	@RequestMapping(value = "/city/cityList", method = RequestMethod.GET)
	public String selectCityListAndCountByPage(Model model, HttpSession httpSession
										, @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage
										, @RequestParam(value = "pagePerRow", required = false, defaultValue = "10") int pagePerRow
										, @RequestParam(value="word",required =false) String word) {
		logger.debug("{} : <- currentPage CityController.java", currentPage);
		logger.debug("{} : <- pagePerRow CityController.java", pagePerRow);
		logger.debug("{} : <- pagePerRow CityController.java", word);
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		Map<String, Object> map = cityService.selectCityListAndCountByPage(currentPage, pagePerRow, word);
		List<City> list = (List<City>)(map.get("list"));
		int countPage = (Integer)map.get("countPage");
		String searchWord = (String) map.get("word");
		model.addAttribute("list", list);
		model.addAttribute("countPage", countPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("word", searchWord);
		return "city/cityList";
	}
	
	// 입력페이지 요청
	@RequestMapping(value="/city/cityInsert", method=RequestMethod.GET)
	public String cityInsert(HttpSession session) {
		// 세션이 없으면 로그인 페이지로 리다이렉트 
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
		return "city/cityInsert";
	}
	
	// 입력 처리요청 service 이용
	@RequestMapping(value="/city/cityInsert", method=RequestMethod.POST)
	public String cityInsert(City city, HttpSession session) {
		// 세션이 없으면 로그인 페이지로 리다이렉트 
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
    	cityService.insertCity(city);
		return "redirect:/city/cityList";
	}
	
	// 업데이트 정보요청 service 이용
	@RequestMapping(value="/city/cityUpdate", method=RequestMethod.GET)
	public String cityUpdate(Model model, HttpSession session, @RequestParam(value="cityId", required=true) int cityId) {
		// 세션이 없으면 로그인 페이지로 리다이렉트 
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
		City city = cityService.updateGetCity(cityId);
		model.addAttribute("city", city);
		return "city/cityUpdate";
	}
	
	// 업데이트 처리요청 service 이용
	@RequestMapping(value="/city/cityUpdate", method=RequestMethod.POST)
	public String cityUpdate(City city, HttpSession session) {
		// 세션이 없으면 로그인 페이지로 리다이렉트 
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
    	cityService.updateCity(city);
		return "redirect:/city/cityList";
	}
	
	// 삭제 service 이용
	@RequestMapping(value="/city/cityDelete", method=RequestMethod.GET)
	public String cityDelete(HttpSession session, @RequestParam(value="cityId", required=true) int cityId) {
		// 세션이 없으면 로그인 페이지로 리다이렉트 
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
    	cityService.deleteCity(cityId);
		return "redirect:/city/cityList";
	}
	
	// 도시 전체 조회
	@RequestMapping(value = "/city/cityListAll", method = RequestMethod.GET)
	public String cityList(HttpSession httpSession, Model model) {
		logger.debug("{} : <- httpSession CityController.java", httpSession);
		logger.debug("{} : <- model CityController.java", model);
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
			List<City> list = cityService.selectCityList();
			logger.debug("{} : <- list CityController.java", list);
			model.addAttribute("list", list);
		return "city/cityList";
		}
}
