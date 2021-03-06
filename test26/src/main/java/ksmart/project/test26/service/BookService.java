package ksmart.project.test26.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class BookService {
	@Autowired
	private BookDao bookDao;

	// 목록조회
	public List<Book> selectBookList() {
		List<Book> list = bookDao.selectBookList();
		return list;
	}
	
/*	//총 목록 수 조회
	public int getBookCount() {
		int totalCount = bookDao.totalCount(keyword);
		return totalCount;
	}*/
	// 업데이트 정보요청
	public Book updateGetBook(int bookId) {
		Book bookOne = bookDao.updateGetBook(bookId);
		return bookOne;
	}
	// 업데이트
	public int updateBook(Book book) {
		int bookOne = bookDao.updateBook(book);
		return bookOne;
	}
	// 삭제
	public int deleteBook(int bookId) {
		int bookOne = bookDao.deleteBook(bookId);
		return bookOne;
	}
	// 등록
	public int insertBook(Book book) {
		int bookOne = bookDao.insertBook(book);
		return bookOne;
	}
	
	// 페이징 작업
	
	public Map<String, Object> getBookListByPage(int currentPage, int rowPerPage, String keyword){
		
		//startRow 선언
		int startRow = 0;
		
		startRow = (currentPage-1) * rowPerPage;
		
		Map<String, Object> map = new HashMap<String, Object>();
		int totalCount = bookDao.totalCount(keyword);
		// map에 startRow와 rowPerPage를 매핑한다.
		map.put("startRow", startRow);
		map.put("rowPerPage", rowPerPage);
		map.put("keyword", keyword);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Book> list = bookDao.selectBookListPage(map);		
		int lastPage = (int)Math.ceil(((double)totalCount/(double)rowPerPage));		
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalCount", totalCount);		
		return returnMap;
	}
}
 