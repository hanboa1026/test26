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

import ksmart.project.test26.service.Idol;
import ksmart.project.test26.service.IdolDao;
import ksmart.project.test26.service.IdolService;

@Controller
public class IdolController{
   
   private static final Logger logger=LoggerFactory.getLogger(IdolController.class);
   
   @Autowired
   private IdolService idolService;
   
   
   
   // 목록조회
   @RequestMapping(value="/idol/idolList")
   public String IdolList(Model model, HttpSession session, 
                     @RequestParam(value="currentPage", required=false, defaultValue="1")int currentPage
   					,@RequestParam(value="searchOption", defaultValue="idol_name")String searchOption
   					,@RequestParam(value="keyword", defaultValue="")String keyword){
	   logger.debug("검색조건{}",searchOption);
	   logger.debug("검색단어{}",keyword);
      if(session.getAttribute("loginMember")==null) {
         return "redirect:/log/login";
      }
      int idolCount = idolService.getIdolCount(searchOption,keyword);
      int pagePerRow = 10;
      int lastPage = (int)(Math.ceil(idolCount/pagePerRow));
      // 마지막페이지 = 총 목록 수 / 10
      logger.debug("현재 페이지 {}번", currentPage);
      List<Idol> list = idolService.getIdolListBYPAGE(currentPage, pagePerRow,searchOption,keyword);
      logger.debug("Idol목록{}",list);
      model.addAttribute("currentPage",currentPage); 
      model.addAttribute("idolCount",idolCount);
      model.addAttribute("lastPage",lastPage);
      model.addAttribute("list",list);
      model.addAttribute("keyword",keyword);
      model.addAttribute("idolCount",idolCount);
      return "idol/idolList";
   }   

   // 입력처리 요청
   @RequestMapping(value="/idol/idolInsert", method=RequestMethod.POST)
   public String idolInsert(Idol idol, HttpSession session) {
      if(session.getAttribute("loginMember")==null) {
         return "redirect:/log/login";
      }
      logger.debug("idol정보 {}번",idol);
      idolService.insertIdol(idol);
      return "redirect:/idol/idolList";
   }
   
   // 입력페이지 요청
   @RequestMapping(value="/idol/idolInsert", method=RequestMethod.GET)
   public String idolInsert(HttpSession session) {
      if(session.getAttribute("loginMember")==null){
         return "redirect:/log/login";
      }
      return "idol/idolInsert";
   }
   
   // 업데이트 정보요청
   @RequestMapping(value="/idol/idolUpdate", method=RequestMethod.GET)
   public String idolUpdate(Model model, @RequestParam(value="idolId", required=true) int idolId, HttpSession session) {
      if(session.getAttribute("loginMember")==null) {
         return "redirect:/log/login";
      }
      logger.debug("idol 번호 {}번",idolId);
      Idol idol = idolService.updateGetIdol(idolId);
      model.addAttribute("idol", idol);
      return "idol/idolUpdate";
   }
   
   // 업데이트 처리요청
   @RequestMapping(value="/idol/idolUpdate", method=RequestMethod.POST)
   public String idolUpdate(Idol idol, HttpSession session) {
      if(session.getAttribute("loginMember")==null) {
         return "redirect:/log/login";
      }
      logger.debug("idol정보 {}번",idol);
      idolService.updateIdol(idol);
      return "redirect:/idol/idolList";
   }
   
   // 삭제
   @RequestMapping(value="/idol/idolDelete" ,method=RequestMethod.GET)
   public String idolDelete(@RequestParam(value="idolId", required=true) int idolId, HttpSession session) {
      if(session.getAttribute("loginMember")==null) {
         return "redirect:/log/login";
      }
      logger.debug("idol 번호 {}번",idolId);
      idolService.deleteIdol(idolId);
      return "redirect:/idol/idolList";
   }
   
}
