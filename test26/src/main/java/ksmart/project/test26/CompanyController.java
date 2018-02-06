package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Company;
import ksmart.project.test26.service.CompanyDao;

@Controller
public class CompanyController {
	@Autowired
	private CompanyDao companyDao;
	
	// 목록조회
	@RequestMapping(value="/company/companyList", method = RequestMethod.GET)
	public String movie(Model model) {
		List<Company> list = companyDao.selectCompanyList();
		model.addAttribute("list",list);
		return "company/companyList";	
	}
    
	// 입력페이지 요청
	@RequestMapping(value="/company/companyInsert", method = RequestMethod.GET)
	public String companyAdd() {
       System.out.println("companyAdd 메소드 출력");
       return "company/companyInsert";
	}
   
	// 입력처리 요청
    @RequestMapping(value="/companyAdd", method = RequestMethod.POST)
	public String companyAdd(Company company) {
        companyDao.insertCompany(company);
        return "redirect:/company/companyList"; 
	}
    
	// 업데이트 처리요청
    @RequestMapping(value="/company/companyUpdate", method = RequestMethod.POST)
    public String companyUpdate(Company company){
    	companyDao.updateCompany(company);
    	return "redirect:/company/companyList";
	}
    
 	// 업데이트 정보요청
    @RequestMapping(value="/company/companyUpdate", method = RequestMethod.GET)
	public String companyUpdate(Model model, @RequestParam(value="companyId", required=true) int companyId){
    	Company company= companyDao.getCompany(companyId);
    	model.addAttribute("company", company);
    	return "company/companyUpdate";
	}

    // 삭제
	@RequestMapping(value="/company/companyDelete", method = RequestMethod.GET)
	public String companyRemove(@RequestParam(value="companyId", required=true) int companyId) {
        companyDao.deleteCompany(companyId);
        return "redirect:/company/companyList";
    } 
}
