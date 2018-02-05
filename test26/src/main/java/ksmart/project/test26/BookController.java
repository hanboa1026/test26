package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Book;
import ksmart.project.test26.service.BookDao;

@Controller
public class BookController {
	@Autowired
	private BookDao bookDao;
	// 목록조회
	@RequestMapping(value="/book/bookList", method=RequestMethod.GET)
	public String bookList(Model model) {
		List<Book> list = bookDao.selectBookList();
		model.addAttribute("list", list);
		return "book/bookList";
	}
	// 업데이트 정보요청
	@RequestMapping(value="/book/bookUpdate", method=RequestMethod.GET)
	public String bookUpdate(Model model, @RequestParam(value="bookId", required=true) int bookId) {
		Book book = bookDao.updateGetBook(bookId);
		model.addAttribute("book", book);
		return "book/bookUpdate";
	}
	// 업데이트
	@RequestMapping(value="/book/bookUpdate", method=RequestMethod.POST)
	public String bookUpdate(Book book) {
		bookDao.updateBook(book);		
		return "redirect:/book/bookList";
	}
	// 삭제
	@RequestMapping(value="/book/bookDelete", method=RequestMethod.GET)
	public String bookDelete(@RequestParam(value="bookId", required=true) int bookId) {
		bookDao.deleteBook(bookId);
		return "redirect:/book/bookList";
	}
}
