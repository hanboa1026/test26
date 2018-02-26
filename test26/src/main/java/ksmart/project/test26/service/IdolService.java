package ksmart.project.test26.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class IdolService {

   @Autowired
   private IdolDao idolDao;
   private static final Logger logger=LoggerFactory.getLogger(IdolService.class);
   
   //아이돌 추가
   public void insertIdol(IdolCommand idolCommand, String path){
	   //idolCommand 객체안에 정보 확인
	   logger.debug("addIdol(IdolCommand idolCommand)메서드 idolCommand is {}",idolCommand);
	   //1.아이돌 추가
	   Idol idol = new Idol();
	   idol.setIdolName(idolCommand.getidolName());
	   //idol 객체안에 정보확인
	   logger.debug("addIdol(IdolCommnad idolCommand)메서드 idol id{}",idol);
	   idolDao.insertIdol(idol);
	   //lastIdol구함
	   int lastIdolId = idolDao.selectedLastId();
	   logger.debug("addIdol(IdolCommand idolCommand)메서드 lastIdolId is{}",lastIdolId);
	   //2.들어온 파일 정보 입력
	   for(MultipartFile file : idolCommand.getFile()) {
		   IdolFile idolFile = new IdolFile();
		   //2-0.마지막에 넣은 아이디 값
		   idolFile.setIdolId(lastIdolId);
		   //2-1.파일 이름
		   UUID uuid = UUID.randomUUID();
		   String fileName = uuid.toString();
		   logger.debug("addIdol(IdolCommand idolCommand) 메서드 fileName is {}",fileName);
		   idolFile.setFileName(fileName);
		   //2-2.파일 확장자
		   String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
		   logger.debug("addIdol(IdolCommand idolCommand) 메서드 fileExt is{}",fileExt);
		   idolFile.setFileExt(fileExt);
		   //2-3.파일 사이즈
		   long fileSize = file.getSize();
		   logger.debug("addIdol(IdolCommand idolCommand) 메서드 fileSize is{}",fileSize);
		   idolFile.setFileSize(fileSize);
		   //2-4.파일 저장
		   File temp = new File("C:\\upload\\"+fileName);
		   try {
			   	file.transferTo(temp);
		   }catch(IllegalStateException e) {
			   e.printStackTrace();
		   }catch(IOException e) {
			   e.printStackTrace();
		   }
		   idolDao.insertIdol(idolFile);				   
	   }
			   
	 
   }
   



// 목록조회+페이지
   public List<Idol> getIdolListBYPAGE(int currentPage, int pagePerRow, String searchOption, String keyword){
      logger.debug("현재 페이지{}번",currentPage);
      logger.debug("목록 수{}개", pagePerRow);
	  Map<String, Object> map = new HashMap<String, Object>();      
      map.put("startRow", (currentPage-1)*pagePerRow);
      //beginRow = (1-1)*10 = 0
      map.put("pagePerRow", pagePerRow);
      //LIMIT (beginRow)0,(PagePerRow)10 : 0번부터 10번까지
      logger.debug("IdolService 검색조건 : {}", searchOption);
      logger.debug("IdolService 검색어 : {}",keyword);
      map.put("searchOption", searchOption);
      map.put("keyword", keyword);
      List<Idol> list = idolDao.selectIdolList(map);
      logger.debug("IdolService 검색 후 아이돌 목록:{}",list);
      return list;
   }
   
   // 총 목록수 조회
   public int getIdolCount(String searchOption, String keyword) {
	   Map<String, Object> map = new HashMap<String, Object>();
	   map.put("searchOption",searchOption);
	   map.put("keyword", keyword);
	   int count = idolDao.getIdolCount(map);
	   return count;
   }

   // 업데이트 정보요청
   public Idol updateGetIdol(int idolId) {
      Idol updateGet = idolDao.updateGetIdol(idolId);
      return updateGet;
   }
   
   // 업데이트
   public int updateIdol(Idol idol) {
      int update = idolDao.updateIdol(idol);
      return update;
   }
   
   //삭제
   public int deleteIdol(int idolId) {
      int delete = idolDao.deleteIdol(idolId);
      return delete;
      
   }
}