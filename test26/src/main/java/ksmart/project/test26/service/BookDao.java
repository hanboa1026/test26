package ksmart.project.test26.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	String localName = "ksmart.project.test26.mapper.BookMapper.";
	private static final Logger logger = LoggerFactory.getLogger(BookDao.class);
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
	// 등록
	public int insertBook(Book book) {
		return sqlSessionTemplate.insert(localName+"insertBook", book);
	}
	
	// 총 카운트
	public int totalCount(String keyword) {
		int totalCount = sqlSessionTemplate.selectOne(localName + "bookCountRow", keyword);
		logger.debug("totalCount() 메소드 실행  totalCount is {}", totalCount);
		return totalCount;
	}
	
	//리스트 페이지 선택
	public List<Book> selectBookListPage(Map<String, Object> map){
		logger.debug("selectBookListPage(Map map) 메소드 map is {}",map);
		List<Book> list = sqlSessionTemplate.selectList(localName + "selectBookPage", map);
		logger.debug("selectBookListPage(Map map) 메소드 list is {}",list);
		return list;
	}
}
