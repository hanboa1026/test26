package ksmart.project.test26;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Country;
import ksmart.project.test26.service.CountryDao;
@Controller
/* spring MVC의 Controller 클래스 선언을 단순화시켜준다.
 *	스프링 컨트롤러, 서블릿을 상속할 필요가 없으며,
 *	@Controller로 등록된 클래스 파일에 대한 bean을 자동으로 생성해준다.
 */
public class CountryController {
	@Autowired
	private CountryDao countryDao;
/* 	@Autowired
 * 	의존관계를 자동설정할 때 사용한다. 타입을 이용하여 의존하는 객체를 삽입해준다.
 * 	해당 타입의 빈객체가 존재하지 않거나 또는 2개 이상 존재할 경우 예외가 발생한다. */
	
	// 목록조회
	@RequestMapping(value="/country/countryList", method=RequestMethod.GET)
/*	@RequestMapping
 * 	URL을 컨트롤러의 매서드와 매핑할 때 사용하는 스프링 프레임워크의 어노테이션이다.
 * 	매서든 내에서 viewName을 별도로 설정하지 않으면 @RequestMapping의 path로
 * 	설정한 URL이 그대로 viewName으로 설정된다.*/
	public String countryList(Model model, HttpSession session) {
		if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
		List<Country> list = countryDao.selectCountryList();
		model.addAttribute("list",list);
		return "country/countryList";
	}
	
	// 입력페이지 요청
	@RequestMapping(value="/countryAdd", method=RequestMethod.GET)
	public String countryInsert(HttpSession session) {
		if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
		return "country/countryInsert";
	}
	   
	// 입력처리 요청
	@RequestMapping(value="/countryAdd", method=RequestMethod.POST)
	public String countryInsert(Country country, HttpSession session) {
		if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
		countryDao.insertCountry(country);
		return "redirect:/country/countryList";
	}
	
	// 업데이트 정보요청
	@RequestMapping(value="/countryModify", method=RequestMethod.GET)
	public String countryUpdate(HttpSession session, Model model,@RequestParam(value="countryId", required=true)int countryId) {
		if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
		Country country = countryDao.selectCountryById(countryId);
		model.addAttribute("country",country);
		return "country/countryUpdate";
	}
	
	// 업데이트 처리요청
	@RequestMapping(value="/countryModify", method=RequestMethod.POST)
	public String countryUpdate(Country country, HttpSession session) {
		if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
		countryDao.updateCountry(country);
		return "redirect:/country/countryList";
	}

	// 삭제
	@RequestMapping(value="/countryRemove", method=RequestMethod.GET)
	public String countryDelete(HttpSession session, @RequestParam(value="countryId", required=true)int countryId) {
		if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
		countryDao.deleteCountry(countryId);
		return "redirect:/country/countryList";
	}	
}
