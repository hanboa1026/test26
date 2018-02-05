package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public List<Company> selectCompanyList() {
		return sqlSessionTemplate.selectList("ksmart.project.test26.service.companyMapper.selectCompany");
	}
	
	// insert company
	public int insertCompany(Company company) {
		return sqlSessionTemplate.insert("ksmart.project.test26.service.companyMapper.insertCompany", company);
	}
	
	// delete company
	public int deleteCompany (int companyId) {
		Company company = new Company();
		company.setCompanyId(companyId);
		return sqlSessionTemplate.delete("ksmart.project.test26.service.companyMapper.deleteCompany", company);
	}
	
	// getCompnay 
	public Company getCompany(int companyId) {
		return sqlSessionTemplate.selectOne("ksmart.project.test26.service.companyMapper.selectCompanyOne");
	}
	
	// update company
	public int updateCompany (Company company) {
		return sqlSessionTemplate.update("ksmart.project.test26.service.companyMapper.updateCompany", company);
	}
}
