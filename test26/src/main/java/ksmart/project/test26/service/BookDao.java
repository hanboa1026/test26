package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	String localName = "ksmart.project.test26.service.bookMapper.";
	// 목록조회
	public List<Book> selectBookList() {
		return sqlSessionTemplate.selectList(localName+"selectBookList");
	}
	// 업데이트 정보요청
	public Book updateGetBook(int bookId) {
		return sqlSessionTemplate.selectOne(localName+"getBook", bookId);
	}
	// 업데이트
	public int updateBook(Book book) {
		return sqlSessionTemplate.update(localName+"updateBook", book);
	}
	// 삭제
	public int deleteBook(int bookId) {
		return sqlSessionTemplate.delete(localName+"deleteBook", bookId);
	}
	// 삽입
	public int insertBook(Book book) {
		return sqlSessionTemplate.insert(localName+"insertBook", book);
	}
}
