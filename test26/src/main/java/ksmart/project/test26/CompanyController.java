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

import ksmart.project.test26.service.Company;
import ksmart.project.test26.service.CompanyCommand;
import ksmart.project.test26.service.CompanyService;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	// 목록조회 service 이용
		@SuppressWarnings("unchecked")
		@RequestMapping(value="/company/companyList")
		public String movie(Model model, HttpSession session, @RequestParam(value="currentPage", defaultValue="1") int currentPage
															, @RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage
															, @RequestParam(value="keyword", defaultValue="") String keyword ) {
			if(session.getAttribute("loginMember") == null ) {
				return "redirect:/log/login"; 
			}
			logger.debug("list Method 실행 currentPage is {}", currentPage);
			logger.debug("list Method 실행 pagePerRow is {}", rowPerPage);
			logger.debug("list Method 실행 keyword is {}", keyword);
			Map<String, Object> map = companyService.getCompanyListByPage(currentPage, rowPerPage, keyword);
			List<Company> list = (List<Company>)map.get("list");
			int lastPage = (Integer)map.get("lastPage");
			int totalCount = (Integer)map.get("totalCount");
			
			model.addAttribute("Companylist",list);
			model.addAttribute("lastPage",lastPage);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("rowPerPage", rowPerPage);
			model.addAttribute("totalCount", totalCount);
			model.addAttribute("keyword", keyword);
			
			return "company/companyList";	
		}
	// 입력페이지 요청
	@RequestMapping(value="/company/companyInsert", method = RequestMethod.GET)
	public String companyAdd(HttpSession session) {
		if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
       return "company/companyInsert";
	}
    
    // 입력처리 요청 service 이용
    @RequestMapping(value="/companyAdd", method = RequestMethod.POST)
	public String companyAdd(CompanyCommand companyCommand, HttpSession session) {
    	// 세션이 없으면 로그인 페이지로 리다이렉트 
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
    	
    	String path = session.getServletContext().getRealPath("/");
		path += "/resources/";
		logger.debug("companyAdd(CompanyCommand companyCommand,HttpSession session) 메소드 path is {}", path);
		companyService.insertCompany(companyCommand, path);
		logger.debug("companyAdd(CompanyCommand companyCommand,HttpSession session) 메소드 path is {}", path);
        return "redirect:/company/companyList"; 
	}
    
    // 업데이트 처리 service 이용
    @RequestMapping(value="/company/companyUpdate", method = RequestMethod.POST)
    public String companyUpdate(Company company, HttpSession session){
    	// 세션이 없으면 로그인 페이지로 리다이렉트
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
    	companyService.updateCompany(company);
    	return "redirect:/company/companyList";
	}
    
    // 업데이트 정보요청 service 이용
    @RequestMapping(value="/company/companyUpdate", method = RequestMethod.GET)
   	public String companyUpdate(Model model, HttpSession session, @RequestParam(value="companyId", required=true) int companyId){
       	// 세션이 없으면 로그인 페이지로 리다이렉트
       	if(session.getAttribute("loginMember") == null ) {
   			return "redirect:/log/login"; 
   		}
       	Company company= companyService.getCompany(companyId);
       	model.addAttribute("company", company);
       	return "company/companyUpdate";
   	}
    
	// 삭제 service 이용
	@RequestMapping(value="/company/companyDelete", method = RequestMethod.GET)
	public String companyRemove(HttpSession session, @RequestParam(value="companyId", required=true) int companyId) {
		// 세션이 없으면 로그인 페이지로 리다이렉트
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
		companyService.deleteCompany(companyId);
        return "redirect:/company/companyList";
    } 
}
