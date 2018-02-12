package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDao {	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	String localName = "ksmart.project.test26.mapper.CompanyMapper.";
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
}
