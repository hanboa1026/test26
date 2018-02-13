package ksmart.project.test26.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IdolService {

   @Autowired
   private IdolDao idolDao;
   private static final Logger logger=LoggerFactory.getLogger(IdolService.class);
   
   // 목록조회+페이지
   public List<Idol> getIdolListBYPAGE(int currentPage, int pagePerRow, String searchOption, String keyword){
      logger.debug("현재 페이지{}번",currentPage);
      logger.debug("목록 수{}개", pagePerRow);
	  Map<String, Object> map = new HashMap<String, Object>();      
      map.put("startRow", (currentPage-1)*pagePerRow);
      //beginRow = (1-1)*10 = 0
      map.put("rowPerPage", pagePerRow);
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
   // 등록
   public int insertIdol(Idol idol) {
      int insert = idolDao.insertIdol(idol);
      return insert;
   }
}