package ksmart.project.test26.service;

import java.util.List;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDao {	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	String localName = "ksmart.project.test26.mapper.CompanyMapper.";
	private static final Logger logger = LoggerFactory.getLogger(CompanyDao.class);
	// 목록조회
	public List<Company> selectCompanyList() {
		return sqlSessionTemplate.selectList(localName + "selectCompany");
	}
	// 업데이트 정보요청
	public Company getCompany(int companyId) {
		return sqlSessionTemplate.selectOne(localName + "selectCompanyOne", companyId);
	}
	// 업데이트
	public int updateCompany (Company company) {
		return sqlSessionTemplate.update(localName + "updateCompany", company);
	}
	// 삭제
	public int deleteCompany (int companyId) {
		Company company = new Company();
		company.setCompanyId(companyId);
		return sqlSessionTemplate.delete(localName + "deleteCompany", company);
	}
	// 등록
	public int insertCompany(Company company) {
		return sqlSessionTemplate.insert(localName + "insertCompany", company);
	}
	// 리스트 페이지 선택
	public List<Company> selectCompanyListPage(Map<String, Object> map) {
		logger.debug("selectCompanyListPage(Map map) 메소드 map is {}",map);
		List<Company> list = sqlSessionTemplate.selectList(localName + "switchingPage", map);
		logger.debug("selectCompanyListPage(Map map) 메소드 list is {}", list);
		return list;
	}
	// companyList total row 
	public int totalCount(String keyword) {
		int totalCount = sqlSessionTemplate.selectOne(localName + "countRow",keyword);
		logger.debug("totalCount() 메소드 totalCount is {}", totalCount);
		return totalCount;
	}
	
	// upload file 
	public int selectLastId() {
		int selectLastId = sqlSessionTemplate.selectOne(localName + "selectLastId");
		logger.debug("selectLastId() 메소드 실행 lastId is {}", selectLastId);
		return selectLastId;
	}
	
	// upload file
	public void insertCompanyFile(CompanyFile companyFile) {
		logger.debug("insertCompanyFile(CompanyFile companyFile) 메소드 실행 companyFile is {}",companyFile);
		sqlSessionTemplate.insert(localName + "insertCompanyFile", companyFile);
	}
}
