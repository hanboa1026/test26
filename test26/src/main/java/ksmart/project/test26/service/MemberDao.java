package ksmart.project.test26.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	String localName = "ksmart.project.test26.service.memberMapper.";		
	/*//회원가입
	public Member insertMember(Member member) {
		return sqlSessionTemplate.insert(statement)
	}*/
	// 로그인
	public Member login(Member member) {
		return sqlSessionTemplate.selectOne(localName + "selectMemberone", member);	
	}
}
