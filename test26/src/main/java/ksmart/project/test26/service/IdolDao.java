package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdolDao {
	private String str = "ksmart.project.test26.service.idolMapper.";
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	// 목록조회
	public List<Idol> selectIdolList(){
		return sqlSessionTemplate.selectList(str+"selectIdolList");
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
