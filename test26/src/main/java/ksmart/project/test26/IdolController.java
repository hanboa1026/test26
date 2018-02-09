package ksmart.project.test26;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Idol;
import ksmart.project.test26.service.IdolDao;
import ksmart.project.test26.service.IdolService;

@Controller
public class IdolController{
	@Autowired
	private IdolService idolService;
	
	
/*	// 목록조회
	@RequestMapping(value="/idol/idolList",method=RequestMethod.GET)
	public String IdolList(Model model, HttpSession session) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/log/login";
		}
		List<Idol> list = idolDao.selectIdolList();
		model.addAttribute("list",list);
		return "idol/idolList";
	}*/	
	// 목록조회
	@RequestMapping(value="/idol/idolList",method=RequestMethod.GET)
	public String IdolList(Model model, HttpSession session) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/log/login";
		}
		List<Idol> list = idolService.selectIdolList();
		model.addAttribute("list",list);
		return "idol/idolList";
	}	
		
/*	// 입력페이지 요청
	@RequestMapping(value="/idol/idolInsert", method=RequestMethod.POST)
	public String idolInsert(Idol idol, HttpSession session) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/log/login";
		}
		idolDao.insertIdol(idol);
		return "redirect:/idol/idolList";
	}*/
	// 입력페이지 요청
	@RequestMapping(value="/idol/idolInsert", method=RequestMethod.POST)
	public String idolInsert(Idol idol, HttpSession session) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/log/login";
		}
		idolService.insertIdol(idol);
		return "redirect:/idol/idolList";
	}
	
	// 입력 처리요청
	@RequestMapping(value="/idol/idolInsert", method=RequestMethod.GET)
	public String idolInsert(HttpSession session) {
		if(session.getAttribute("loginMember")==null){
			return "redirect:/log/login";
		}
		return "idol/idolInsert";
	}
	
	
/*	// 업데이트 정보요청
	@RequestMapping(value="/idol/idolUpdate", method=RequestMethod.GET)
	public String idolUpdate(Model model, @RequestParam(value="idolId", required=true) int idolId, HttpSession session) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/log/login";
		}
		Idol idol = idolDao.updateGetIdol(idolId);
		model.addAttribute("idol", idol);
		return "idol/idolUpdate";
	}*/
	// 업데이트 정보요청
	@RequestMapping(value="/idol/idolUpdate", method=RequestMethod.GET)
	public String idolUpdate(Model model, @RequestParam(value="idolId", required=true) int idolId, HttpSession session) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/log/login";
		}
		Idol idol = idolService.updateGetIdol(idolId);
		model.addAttribute("idol", idol);
		return "idol/idolUpdate";
	}
	
	/*// 업데이트 처리요청
	@RequestMapping(value="/idol/idolUpdate", method=RequestMethod.POST)
	public String idolUpdate(Idol idol, HttpSession session) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/log/login";
		}
		idolDao.updateIdol(idol);
		return "redirect:/idol/idolList";
	}*/
	// 업데이트 처리요청
	@RequestMapping(value="/idol/idolUpdate", method=RequestMethod.POST)
	public String idolUpdate(Idol idol, HttpSession session) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/log/login";
		}
		idolService.updateIdol(idol);
		return "redirect:/idol/idolList";
	}
	
/*	// 삭제
	@RequestMapping(value="/idol/idolDelete" ,method=RequestMethod.GET)
	public String idolDelete(@RequestParam(value="idolId", required=true) int idolId, HttpSession session) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/log/login";
		}
		idolDao.deleteIdol(idolId);
		return "redirect:/idol/idolList";
	}*/
	// 삭제
	@RequestMapping(value="/idol/idolDelete" ,method=RequestMethod.GET)
	public String idolDelete(@RequestParam(value="idolId", required=true) int idolId, HttpSession session) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/log/login";
		}
		idolService.deleteIdol(idolId);
		return "redirect:/idol/idolList";
	}
	
}

