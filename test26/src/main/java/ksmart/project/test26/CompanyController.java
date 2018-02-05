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
	
	
	@RequestMapping(value="/company/companyList", method = RequestMethod.GET)
	public String movie(Model model) {
			List<Company> list = companyDao.selectCompanyList();
			model.addAttribute("list",list);
		return "company/companyList";	
	}
	
	// 회사추가 요청
    @RequestMapping(value="/companyAdd", method = RequestMethod.POST)
    public String companyAdd(Company company) {
        companyDao.insertCompany(company);
        return "redirect:/company/companyList"; 
    }
    // 회사추가 폼
    @RequestMapping(value="/company/companyInsertForm", method = RequestMethod.GET)
    public String companyAdd() {
        System.out.println("companyAdd 메소드 실행");
        return "company/companyInsertForm";
    }
    
 // 회사 삭제
    @RequestMapping(value="/company/companyDelete", method = RequestMethod.GET)
    public String companyRemove(@RequestParam(value="companyId", required=true) int companyId) {
        companyDao.deleteCompany(companyId);
        return "redirect:/company/companyList";
    }
    
 // 회사 수정 폼 요청
    @RequestMapping(value="/company/companyUpdate", method = RequestMethod.GET)
    public String companyUpdate(Model model, @RequestParam(value="companyId", required=true) int companyId){
        Company company= companyDao.getCompany(companyId);
        model.addAttribute("company", company);
        return "company/companyUpdate";
    }
    
    // 회사 수정 요청
    @RequestMapping(value="/company/companyUpdate", method = RequestMethod.POST)
    public String companyUpdate(Company company){
        companyDao.updateCompany(company);
        return "redirect:/company/companyList";
    }

}
