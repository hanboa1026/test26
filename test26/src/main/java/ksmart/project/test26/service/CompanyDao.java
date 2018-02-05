package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	String localName = "ksmart.project.test26.service.companyMapper.";
	public List<Company> selectCompanyList() {
		return sqlSessionTemplate.selectList(localName + "selectCompany");
	}
	
	// insert company
	public int insertCompany(Company company) {
		return sqlSessionTemplate.insert(localName + "insertCompany", company);
	}
	
	// delete company
	public int deleteCompany (int companyId) {
		Company company = new Company();
		company.setCompanyId(companyId);
		return sqlSessionTemplate.delete(localName + "deleteCompany", company);
	}
	
	// getCompnay 
	public Company getCompany(int companyId) {
		return sqlSessionTemplate.selectOne(localName + "selectCompanyOne", companyId);
	}
	
	// update company
	public int updateCompany (Company company) {
		return sqlSessionTemplate.update(localName + "updateCompany", company);
	}
}
