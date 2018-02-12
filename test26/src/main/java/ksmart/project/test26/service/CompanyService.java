package ksmart.project.test26.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyService {
	
	@Autowired
	private CompanyDao companyDao;
	private static final Logger logger = LoggerFactory.getLogger(CompanyService.class);
	
	
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
	
	// 페이징 작업
	public Map<String, Object> getCompanyListByPage(int currentPage, int rowPerPage){
		//startRow 선언
		int startRow = 0;
		
		// 현재페이지 * 보여줄 개수로 시작행을 구한다.
		startRow = (currentPage-1) * rowPerPage;
		
		Map map = new HashMap();
		
		// map에 startRow와 rowPerPage를 매핑한다.
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
		
		
		/*
		 * currentPage & rowPerPage -> startRow
		 * 1. selectSampleListByPage(Map) -> List
		 * 2. totalCount / rowPerPage -> int
		 */
		
		Map returnMap = new HashMap();
		
		List<Company> list = companyDao.selectCompanyListPage(map);
		
		int totalCount = companyDao.totalCount();
		
		int lastPage = (int)Math.ceil(((double)totalCount/(double)rowPerPage));
		
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		
		return returnMap;
	}

	
	

}
