package ksmart.project.test26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyService {
	
	@Autowired
	private CompanyDao companyDao;
	
	
	// 목록조희
	public List<Company> selectCompanyList() {
		List<Company> list = companyDao.selectCompanyList();
		return list;
	}
	
	// 입력처리서비스
	public int insertCompany(Company company) {
		int row = companyDao.insertCompany(company);
		return row;
	}
	
	// 회원하나 정보 받기
	public Company getCompany(int companyId) {
		Company one = companyDao.getCompany(companyId);
		return one;
	}
	
	// 업데이트
	public int updateCompany (Company company) {
		int row = companyDao.updateCompany(company);
		return row;
	}
	
	// 삭제
	public int deleteCompany(int companyId) {
		int row = companyDao.deleteCompany(companyId);
		return row;
	}
	
	

}
