package ksmart.project.test26.service.country;

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
public class CountryService {
	
	private static final Logger logger = LoggerFactory.getLogger(CountryService.class);

	@Autowired
	private CountryDao countryDao;
	
	// 목록조회
	public List<Country> getCountryList(int currentPage, int pagePerRow,String searchOption, String keyword){
		logger.debug("현재 페이지 {}번",currentPage);
		logger.debug("목록 수 {}개",pagePerRow);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("beginRow", (currentPage-1)*pagePerRow);
		//beginRow = (1-1)*10 = 0
		map.put("pagePerRow", pagePerRow);
		//LIMIT (beginRow)0,(pagePerRow)10 : 0번째부터 10번째까지
		logger.debug("CountryService 검색조건 : {}",searchOption);
		logger.debug("CountryService 검색어 : {}",keyword);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		List<Country> list = countryDao.selectCountryList(map);
		logger.debug("CountryService 검색후 나라 목록 : {}",list);
		
		return list;
	}
	
	// 파일목록조회
	public CountryAndCountryFile getCountryFileList(int countryId) {
		CountryAndCountryFile countryAndCountryFile = countryDao.selectCountryAndCountryFile(countryId);
		logger.debug("CountryService -- CountryAndCountryFile is {}",countryAndCountryFile);
		return countryAndCountryFile;
	}
	
	// 총목록수조회
	public int getCountryCount(String searchOption, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		int count = countryDao.getCountryCount(map);
		return count;
	}

	// 입력처리서비스
	public void insertCountry(CountryCommand countryCommand, String path) {
		Country country = new Country();
		CountryFile countryFile = new CountryFile();
		country.setCountryName(countryCommand.getCountryName());
		logger.debug("countryCommand is {} ", countryCommand.getCountryName());
		countryDao.insertCountry(country);
		logger.debug("country is {} ", country);
		int countryId = countryDao.selectLastId();
		logger.debug("countryId is {} ", countryId);
		
		for(MultipartFile file : countryCommand.getFile()) {
			// 1. DB에 입력...
			UUID uuid = UUID.randomUUID();
			// 파일 이름
			String fileName = uuid.toString();
			// 중복되지 않은 이름 랜덤...
			String originalName = file.getOriginalFilename();
			// 파일 확장자
			int pos = originalName.lastIndexOf(".");
			// 오리지널 이름에서 마지막 .
			String fileExt = originalName.substring(pos+1); // 오리지널 파일 확장자
			// 파일 크기
			long fileSize = file.getSize(); // 오리지널 파일 사이즈
			logger.debug("fileSize is {} ", fileSize);
			countryFile.setCountryId(countryId);
			countryFile.setFileName(fileName);
			countryFile.setFileExt(fileExt);
			countryFile.setFileSize(fileSize);
			logger.debug("countryFile(id,name,ext,size) is {} ", countryFile);
			countryDao.insertCountryFile(countryFile);
			
			// 2. 파일을 저장 (resources)
			File temp = new File(path+"\\"+fileName+"."+fileExt);
			try {
				file.transferTo(temp);
			} catch(IllegalStateException e){
				e.printStackTrace();
				if (temp.exists()) {
					if (temp.delete()) {
						logger.debug("{} 파일 삭제 성공", temp);
					}else {
						logger.debug("{} 파일 삭제 실패", temp);
					}
				}
			} catch (IOException e) {
					e.printStackTrace();
					if (temp.exists()) {
						logger.debug("{} 파일 삭제 성공", temp);
					}else {
						logger.debug("{} 파일 삭제 실패", temp);
					}
				}
			}
		}

	
	// 하나정보받기
	public Country getCountry(int countryId) {
		Country one = countryDao.selectCountryById(countryId);
		return one;
	}
	
	// 업데이트
	public int updateCountry(Country country) {
		int row = countryDao.updateCountry(country);
		return row;
	}
	
	// 삭제
	public int deleteCountry(int countryId) {
		int row = countryDao.deleteCountry(countryId);
		return row;
	}
}
