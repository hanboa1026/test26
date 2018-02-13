package ksmart.project.test26;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Book;
import ksmart.project.test26.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	// 목록조회 service 이용
	@RequestMapping(value="/book/bookList")
	public String bookList(Model model, HttpSession session, @RequestParam(value="currentPage", defaultValue="1") int currentPage
															, @RequestParam(value="rowPerPage", defaultValue="10") int rowPerPage) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/log/login";
		}
		
		logger.debug("booklist method 실행 currentpage is{}", currentPage);
		logger.debug("booklist method 실행 rowPerPage is{}", rowPerPage);
		Map map = bookService.getBookListByPage(currentPage, rowPerPage);
		List<Book> list = (List<Book>)map.get("list");
		int lastPage = (Integer)map.get("lastPage");
		model.addAttribute("bookList", list);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		
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
	
	// 입력 처리요청 service 이용
	@RequestMapping(value="/book/bookInsert", method=RequestMethod.POST)
	public String bookInsert(Book book, HttpSession session) {
		// 세션이 없으면 로그인 페이지로 리다이렉트
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
    	bookService.insertBook(book);
		return "redirect:/book/bookList";
	}
	
	// 업데이트 정보요청 service 이용
	@RequestMapping(value="/book/bookUpdate", method=RequestMethod.GET)
	public String bookUpdate(Model model, HttpSession session, @RequestParam(value="bookId", required=true) int bookId) {
		// 세션이 없으면 로그인 페이지로 리다이렉트
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
		Book book = bookService.updateGetBook(bookId);
		model.addAttribute("book", book);
		return "book/bookUpdate";
	}
	
	// 업데이트 처리요청 service 이용
	@RequestMapping(value="/book/bookUpdate", method=RequestMethod.POST)
	public String bookUpdate(Book book, HttpSession session) {
		// 세션이 없으면 로그인 페이지로 리다이렉트
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
    	bookService.updateBook(book);		
		return "redirect:/book/bookList";
	}

	// 삭제 service 이용
	@RequestMapping(value="/book/bookDelete", method=RequestMethod.GET)
	public String bookDelete(HttpSession session, @RequestParam(value="bookId", required=true) int bookId) {
		// 세션이 없으면 로그인 페이지로 리다이렉트
    	if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
    	bookService.deleteBook(bookId);
		return "redirect:/book/bookList";
	}	
}
