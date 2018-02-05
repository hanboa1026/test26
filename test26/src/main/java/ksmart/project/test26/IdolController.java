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
	@RequestMapping(value="/idol/idolDelete" ,method=RequestMethod.POST)
	public String idolDelete(@RequestParam(value="idolId", required=true) int idolId) {
			idolDao.idolDelete(idolId);
			return "redirect:/idolList";
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
	
	
	
    }
 