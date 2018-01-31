package ksmart.project.test26;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		return "company/CompanyList";
		
	}
}
