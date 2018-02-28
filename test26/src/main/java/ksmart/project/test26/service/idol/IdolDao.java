package ksmart.project.test26.service.idol;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdolDao {
   private String str = "ksmart.project.test26.mapper.IdolMapper.";
   @Autowired
   private SqlSessionTemplate sqlSessionTemplate;
   private static final Logger logger=LoggerFactory.getLogger(IdolDao.class);

   // 목록수 조회
   public int getIdolCount(Map<String, Object> map) {
      return sqlSessionTemplate.selectOne(str+"getIdolCount",map);
   }
   // 목록조회
   public List<Idol> selectIdolList(Map<String, Object> map){
      return sqlSessionTemplate.selectList(str+"selectIdolList",map);
   }
   // 업데이트 정보요청
   public Idol updateGetIdol(int idolId) {
      return sqlSessionTemplate.selectOne(str+"getIdol", idolId);
   }
   // 업데이트
   public int updateIdol(Idol idol) {
      return sqlSessionTemplate.update(str+"updateIdol", idol);
   }
   // 삭제
   public int deleteIdol(int idolId) {
      return sqlSessionTemplate.delete(str+"deleteIdol",idolId);
   }
   // 등록
   public int insertIdol(Idol idol) {
      return sqlSessionTemplate.insert(str+"insertIdol",idol);
   }
   //아이돌 추가시 마지막 Id값 찾는 부분
   public int selectedLastId() {
	  return sqlSessionTemplate.selectOne(str+"selectLastId");
   }
   //아이돌 추가시 파일첨부
   public void insertIdol(IdolFile idolFile) {
	   sqlSessionTemplate.insert(str+"insertIdolFile",idolFile);
   }
}