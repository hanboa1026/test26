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
	public List<Idol> selectIdolList(){
		return sqlSessionTemplate.selectList(str+"selectIdolList");
	}
	
	//delete
	public int idolDelete(int idolId) {
			return sqlSessionTemplate.delete(str+"",idolId);
	}

	//insert
	public int insertIdol(Idol idol) {
		return sqlSessionTemplate.insert(str+"insertIdol",idol);
		
	}
}
