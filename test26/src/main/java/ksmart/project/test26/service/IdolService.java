package ksmart.project.test26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IdolService {

	@Autowired
	private IdolDao idolDao;
	
	// 목록조회
	public List<Idol> selectIdolList() {
		List<Idol> list = idolDao.selectIdolList();
		return list;
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
