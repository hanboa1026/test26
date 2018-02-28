package ksmart.project.test26.service.city;

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
public class CityService {
	@Autowired
	private CityDao cityDao;
	private static final Logger logger = LoggerFactory.getLogger(CityService.class);
	// City 및 file 수정 Form
		public CityAndCityFile selectCityJoinFile(int cityId) {
			logger.debug("{} : <-- cityId selectCityJoinFile CityService.java", cityId);
			return cityDao.selectCityJoinFile(cityId);
		}
	// City 조회(페이징) + 검색
	public Map<String, Object> selectCityListAndCountByPage(int currentPage, int pagePerRow, String word) {
		logger.debug("{} : <- currentPage cityService.java", currentPage);
		logger.debug("{} : <- pagePerRow cityService.java", pagePerRow);
		logger.debug("{} : word cityService.java", word);
		int startPage = 0;
		if(currentPage > 1) {
			startPage = (currentPage-1)*pagePerRow;
		}
		// DAO에 시작 페이지와 행의 수 보내기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("word", word);
		map.put("startPage", startPage);
		map.put("pagePerRow", pagePerRow);
		List<City> list = cityDao.selectCityListByPage(map);
		logger.debug("{} : <- list cityService.java", list);
		// 총 행의 수를 보여줄 행의 수로 나눈 뒤 나머지가 0일 경우는 넘어가고 아닐 경우 +1 한다.
		int count = cityDao.selectCityCountByPage(map);
		logger.debug("{} : <- count cityService.java", count);
		int countPage = count/pagePerRow;
		if(count%pagePerRow != 0) {
			countPage++;
		}
		logger.debug("{} : <- countPage cityService.java", countPage);
		// list, 페이지 수 리턴
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("word", word);
		returnMap.put("list", list);
		returnMap.put("countPage", countPage);
		return returnMap;
		}
	// City 전체 조회
		public List<City> selectCityList() {
			return cityDao.selectCityList();
		}
	// City 업데이트 정보요청
	public City updateGetCity(int cityId) {
		City city = cityDao.updateGetCity(cityId);
		return city;
	}
	// City 업데이트
	public int updateCity(City city) {
		int cityOne = cityDao.updateCity(city);
		return cityOne;
	}
	// City 삭제
	public int deleteCity(int cityId) {
		int cityOne = cityDao.deleteCity(cityId);
		return cityOne;
	}
	// City File 삭제
	public int deleteCityFile(int cityId) {
		int cityFileOne = cityDao.deleteCityFile(cityId);
		return cityFileOne;
	}
	// City 등록 및 file 추가
	public void insertCity(CityCommand cityCommand, String path) {
		// 매개변수 city 값 확인
		logger.debug("insertCity(CityCommand cityCommand) 메서드 cityCommand is {}", cityCommand);
		// City 생성자로 객체 생성
		City city = new City();
		// cityCommand로 생성된 객체에 값 셋팅
		city.setCityName(cityCommand.getCityName());
		// city 테이블 입력 메서드 호출하고 cityId값을 리턴받음
		cityDao.insertCity(city);
		// 폼에서 파일이 있을 경우 반복문을 실행
		for(MultipartFile file : cityCommand.getFile()) {
			// CityFile 객체 생성
			CityFile cityFile = new CityFile();
			// 랜덤이름 넣기
			UUID uuid = UUID.randomUUID();
			// String타입으로 중복되지 않은 이름 랜덤입력받기 / replace(- 없애기)
			String fileName = uuid.toString().replace("-", ""); 
			// 파일확장자 추출하기
			String originalName = file.getOriginalFilename();
			logger.debug("insertCity(CityCommand cityCommand) 메서드 originalName is {}",originalName);
			// 오리지널 이름에서 . 다음 확장자 추출
			String fileExt = originalName.substring(originalName.lastIndexOf(".")+1);
			// 문자열에 있는 모든 영문자를 소문자로 변환
			fileExt = fileExt.toLowerCase(); 
			logger.debug("insertCity(CityCommand cityCommand) 메서드 fileExt is {}",fileExt);
			// 파일사이즈 받기
			long fileSize = file.getSize();
			logger.debug("insertCity(CityCommand cityCommand) 메서드 fileSize is {}",fileSize);
			// cityFile 객체에 필드를 셋팅해준후 insertCityFile 메서드 호출
			cityFile.setCityId(city.getCityId());
			cityFile.setFileName(fileName);
			cityFile.setFileExt(fileExt);
			cityFile.setFileSize(fileSize);
			cityDao.insertCityFile(cityFile);
			// 파일 저장 경로 설정
			File temp = new File(path+fileName+"."+fileExt); // resource로 변경하기
			logger.debug("full file name : {}", temp);
			try {
				file.transferTo(temp);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}