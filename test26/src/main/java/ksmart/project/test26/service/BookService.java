package ksmart.project.test26.service;

import java.util.List;

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
}
