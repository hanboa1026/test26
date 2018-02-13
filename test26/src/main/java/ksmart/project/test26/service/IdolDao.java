package ksmart.project.test26.service;

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

	// 총갯수
	public int getIdolCount() {
		return sqlSessionTemplate.selectOne(str+"getIdolCount");
	}
	
	// 목록조회
	public List<Idol> selectIdolList(Map<String, Integer> map){
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
}
