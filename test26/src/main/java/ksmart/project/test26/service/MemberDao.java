package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	String localName = "ksmart.project.test26.mapper.MemberMapper.";		
	// 목록조회
	public List<Member> selectMemberList(){
		return sqlSessionTemplate.selectList(localName + "selectMemberList");
	}
	// 등록
	public int insertMember(Member member) {
		return sqlSessionTemplate.insert(localName + "insertMember", member);	
	}	
	// 업데이트 정보요청
	public Member selectMemberByNo(int memberNo) {
		return sqlSessionTemplate.selectOne(localName + "selectMemberByNo", memberNo);
	}	
	// 업데이트
	public int updateMember(Member member) {
		return sqlSessionTemplate.update(localName + "updateMember", member);
	}	
	// 삭제
	public int deleteMember(int memberNo) {
		return sqlSessionTemplate.delete(localName + "deleteMember", memberNo);
	}
	// 로그인
	public Member login(Member member) {
		return sqlSessionTemplate.selectOne(localName + "selectMemberone", member);	
	}
}
