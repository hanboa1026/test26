package ksmart.project.test26.service.company;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
	/*public int insertCompany(Company company) {
		int row = companyDao.insertCompany(company);
		return row;
	}
*/	// 회원하나 정보 받기
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
	public Map<String, Object> getCompanyListByPage(int currentPage, int rowPerPage, String keyword){
		logger.debug("getCompanyListByPage()메소드 실행 currentPage is {}", currentPage);
		logger.debug("getCompanyListByPage()메소드 실행 rowPerpage is {}", rowPerPage);
		logger.debug("getCompanyListByPage()메소드 실행 keyword is {}", keyword);
		//startRow 선언
		int startRow = 0;
		// 현재페이지 * 보여줄 개수로 시작행을 구한다.
		startRow = (currentPage-1) * rowPerPage;
		Map<String, Object> map = new HashMap<String, Object>();
		int totalCount = companyDao.totalCount(keyword);
		// map에 startRow와 rowPerPage를 매핑한다.
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
		map.put("keyword", keyword);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Company> list = companyDao.selectCompanyListPage(map);
		int lastPage = (int)Math.ceil(((double)totalCount/(double)rowPerPage));
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalCount", totalCount);
		return returnMap;
	}
	
	public void insertCompany(CompanyCommand companyCommand, String path) {
		logger.debug("insertCompany(CompanyCommand companyCommand) 메소드 실행 CompanyCommand is {}",companyCommand);
		Company company = new Company();
		company.setCompanyName(companyCommand.getCompanyName());
		companyDao.insertCompany(company);
		logger.debug("companyDao.insertCompnay(company) company is {}", company);
		int companyId = companyDao.selectLastId();
		logger.debug("int companyId = companyDao.selectLastId(); companyId is {}", companyId);
		
		for(MultipartFile file : companyCommand.getFile()) {
			
			CompanyFile companyFile = new CompanyFile();
			UUID uid = UUID.randomUUID();
			String fileName = uid.toString();
			String originalName = file.getOriginalFilename();
			int pos = originalName.lastIndexOf(".");
			logger.debug("aploadCompany(CompanyCommand companyCommand) 메서드 pos is {}", pos);
			
			String fileExt = originalName.substring(pos+1);
			
			long fileSize = file.getSize();
			
			companyFile.setCompanyId(companyId);
			companyFile.setFileName(fileName);
			companyFile.setFileExt(fileExt);
			companyFile.setFileSize(fileSize);
			companyDao.insertCompanyFile(companyFile);
			
			File temp = new File(path + fileName);
			try {
				file.transferTo(temp);
			} catch (IllegalStateException e) {
				e.printStackTrace();
				if (temp.exists()) {
					if (temp.delete()) {
						logger.debug("uploadCompany(CompanyCommand companyCommand) 메서드 {} 파일 삭제 성공", temp);
					} else {
						logger.debug("uploadCompany(CompanyCommand companyCommand) 메서드 {} 파일 삭제 실패", temp);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				if (temp.exists()) {
					logger.debug("uploadCompany(CompanyCommand companyCommand) 메서드 {} 파일 삭제 성공", temp);
				} else {
					logger.debug("uploadCompany(CompanyCommand companyCommand) 메서드 {} 파일 삭제 실패", temp);
				}
			}
		}
	}
}
		
