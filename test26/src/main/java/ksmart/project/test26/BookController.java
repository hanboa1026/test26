package ksmart.project.test26;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	public String bookList(Model model, HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/log/login";
		}
		List<Book> list = bookDao.selectBookList();
		model.addAttribute("list", list);
		return "book/bookList";
	}
	
	// 입력페이지 요청
	@RequestMapping(value="/book/bookInsert", method=RequestMethod.GET)
	public String bookInsert(HttpSession session) {
		// 세션이 없으면 로그인 페이지로 리다이렉트
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
		return "book/bookInsert";
	}
	
	// 입력 처리요청
	@RequestMapping(value="/book/bookInsert", method=RequestMethod.POST)
	public String bookInsert(Book book, HttpSession session) {
		// 세션이 없으면 로그인 페이지로 리다이렉트
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
		bookDao.insertBook(book);
		return "redirect:/book/bookList";
	}
	
	// 업데이트 정보요청
	@RequestMapping(value="/book/bookUpdate", method=RequestMethod.GET)
	public String bookUpdate(Model model, HttpSession session, @RequestParam(value="bookId", required=true) int bookId) {
		// 세션이 없으면 로그인 페이지로 리다이렉트
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
		Book book = bookDao.updateGetBook(bookId);
		model.addAttribute("book", book);
		return "book/bookUpdate";
	}
	
	// 업데이트 처리요청
	@RequestMapping(value="/book/bookUpdate", method=RequestMethod.POST)
	public String bookUpdate(Book book, HttpSession session) {
		// 세션이 없으면 로그인 페이지로 리다이렉트
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
		bookDao.updateBook(book);		
		return "redirect:/book/bookList";
	}

	// 삭제
	@RequestMapping(value="/book/bookDelete", method=RequestMethod.GET)
	public String bookDelete(HttpSession session, @RequestParam(value="bookId", required=true) int bookId) {
		// 세션이 없으면 로그인 페이지로 리다이렉트
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
		bookDao.deleteBook(bookId);
		return "redirect:/book/bookList";
	}	
}
