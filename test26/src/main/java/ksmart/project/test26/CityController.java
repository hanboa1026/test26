package ksmart.project.test26;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.city.City;
import ksmart.project.test26.service.city.CityAndCityFile;
import ksmart.project.test26.service.city.CityCommand;
import ksmart.project.test26.service.city.CityService;

@Controller
public class CityController {
	@Autowired
	private CityService cityService;
	private static final Logger logger = LoggerFactory.getLogger(CityController.class);
	// City 및 File 수정 Form
	@RequestMapping(value ="/city/cityUpdate", method = RequestMethod.GET)
	public String selectCityJoinFile(HttpSession httpSession, Model model, @RequestParam(value = "cityId") int cityId) {
		logger.debug("{} : <-- cityId selectCityJoinFile CityController.java", cityId);
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		// id와 name과 list 받기
		CityAndCityFile cityAndCityFile = cityService.selectCityJoinFile(cityId);
		logger.debug("{} : <-- cityAndCityFile selectCityJoinFile CityController.java", cityAndCityFile);
		model.addAttribute("cityAndCityFile", cityAndCityFile);
		// 절대경로 셋팅
		String rootPath = httpSession.getServletContext().getRealPath("/");
		String attachPath = "resources/upload/city";
		String path = rootPath + attachPath;
		logger.debug("{} : <-- path selectCityJoinFile CityController.java", path);
		model.addAttribute("path", path);	
		return "city/cityUpdate";
	}
	// City 조회(페이징) + 검색
	@RequestMapping(value = "/city/cityList", method = RequestMethod.GET)
	public String selectCityListAndCountByPage(Model model, HttpSession httpSession
										, @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage
										, @RequestParam(value = "pagePerRow", required = false, defaultValue = "10") int pagePerRow
										, @RequestParam(value="word", required = false) String word) {
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
	
	// City 입력페이지 요청
	@RequestMapping(value="/city/cityInsert", method=RequestMethod.GET)
	public String cityInsert(HttpSession session) {
		// 세션이 없으면 로그인 페이지로 리다이렉트 
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
		return "city/cityInsert";
	}
	
	// City 입력 및 File 업로드 처리요청 service 이용
	@RequestMapping(value="/city/cityInsert", method=RequestMethod.POST)
	public String cityInsert(HttpServletRequest request, CityCommand cityCommand, HttpSession session) {
		logger.debug("title:"+cityCommand.getCityName());
		logger.debug("size:"+cityCommand.getFile().size());
		// 세션이 없으면 로그인 페이지로 리다이렉트 
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
    	// resource 폴더 경로 받음
   // 	String path = session.getServletContext().getRealPath("/");
    	String path = request.getSession().getServletContext().getRealPath("/");
    	path += "resources/upload/city";
    	logger.debug("insertCity(cityCommand cityCommand, HttpSession session) 메서드 path is {}",path);
    	// 입력 서비스 메서드 호출
    	cityService.insertCity(cityCommand,path);
		return "redirect:/city/cityList";
	}
	
	// City 업데이트 정보요청 service 이용
	@RequestMapping(value="/city/cityUpdateOnly", method=RequestMethod.GET)
	public String cityUpdate(Model model, HttpSession session, @RequestParam(value="cityId", required=true) int cityId) {
		// 세션이 없으면 로그인 페이지로 리다이렉트 
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
		City city = cityService.updateGetCity(cityId);
		model.addAttribute("city", city);
		return "city/cityUpdateOnly";
	}
	
	// City 업데이트 처리요청 service 이용
	@RequestMapping(value="/city/cityUpdate", method=RequestMethod.POST)
	public String cityUpdate(City city, HttpSession session) {
		// 세션이 없으면 로그인 페이지로 리다이렉트 
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
    	cityService.updateCity(city);
		return "redirect:/city/cityList";
	}
	
	// City, CityFile 삭제 service 이용
	@RequestMapping(value="/city/cityDelete", method=RequestMethod.GET)
	public String cityDelete(HttpSession session, @RequestParam(value="cityId", required=true) int cityId) {
		// 세션이 없으면 로그인 페이지로 리다이렉트 
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
    	cityService.deleteCityFile(cityId);
    	cityService.deleteCity(cityId);
		return "redirect:/city/cityList";
	}
	
	// City 도시 전체 조회
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