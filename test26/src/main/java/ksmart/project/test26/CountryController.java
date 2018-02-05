package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
/* 의존관계를 자동설정할 때 사용한다. 타입을 이용하여 의존하는 객체를 삽입해준다.
 * 해당 타입의 빈객체가 존재하지 않거나 또는 2개 이상 존재할 경우 예외가 발생한다.
 */

	
	//나라 목록 요청
	@RequestMapping(value="/country/countryList", method=RequestMethod.GET)
/* URL을 컨트롤러의 매서드와 매핑할 때 사용하는 스프링 프레임워크의 어노테이션이다.
 * 매서든 내에서 viewName을 별도로 설정하지 않으면 @RequestMapping의 path로
 * 설정한 URL이 그대로 viewName으로 설정된다.
 */
	public String CountryList(Model model) {
		List<Country> list = countryDao.selectCountryList();
		model.addAttribute("list",list);
		return "country/countryList";
	}
	
	//나라 추가 폼 요청
	@RequestMapping(value="/country/countryInsertForm", method=RequestMethod.GET)
	public String CountryInsert() {
		
		return "country/countryInsertForm";
	}
	
	//나라 추가 액션 요청
	@RequestMapping(value="/countryAdd", method=RequestMethod.POST)
	public  String CountryInsert(Country country) {
		countryDao.insertCountry(country);
		return "redirect:/country/countryList";
	}
}
