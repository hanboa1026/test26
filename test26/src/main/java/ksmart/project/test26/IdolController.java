package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Idol;
import ksmart.project.test26.service.IdolDao;

@Controller
    public class IdolController{
	@Autowired
	private IdolDao idolDao;
	
	
	//List
	@RequestMapping(value="/idol/idolList",method=RequestMethod.GET)
	public String IdolList(Model model) {
		List<Idol> list = idolDao.selectIdolList();
		model.addAttribute("list",list);
		return "idol/idolList";		
	}
	//Idol delete
	@RequestMapping(value="/idol/idolDelete" ,method=RequestMethod.GET)
	public String idolDelete(@RequestParam(value="idolId", required=true) int idolId) {
			idolDao.deleteIdol(idolId);
			return "redirect:/idol/idolList";
	}
    //입력(액션) 요청
	@RequestMapping(value="/idol/idolInsert", method=RequestMethod.POST)
	public String idolInsert(Idol idol) {
		idolDao.insertIdol(idol);
		return "redirect:/idol/idolList";
	}
	
	//입력페이지 요청
	@RequestMapping(value="/idol/idolInsert", method=RequestMethod.GET)
	public String idolInsert() {
		System.out.println("insert form 요청일까?? 몰라");
		 return "idol/idolInsert";
	}
	
	
	//수정폼 요청 
	@RequestMapping(value="/idol/idolUpdate", method=RequestMethod.GET)
	public String idolUpdate(Model model, @RequestParam(value="idolId", required=true) int idolId) {
		Idol idol = idolDao.updateGetIdol(idolId);
		model.addAttribute("idol", idol);
		return "idol/idolUpdate";
	}
	//수정요청
	@RequestMapping(value="/idol/idolUpdate", method=RequestMethod.POST)
	public String idolUpdate(Idol idol) {
		idolDao.updateIdol(idol);
		return "redirect:/idol/idolList";
	}
    }
 