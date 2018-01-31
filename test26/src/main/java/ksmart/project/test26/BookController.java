package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ksmart.project.test26.service.Book;
import ksmart.project.test26.service.BookDao;

@Controller
public class BookController {
	@Autowired
	private BookDao bookDao;
	@RequestMapping(value="/bookList.do", method=RequestMethod.GET)
	public String bookList(Model model) {
		List<Book> list = bookDao.selectBookList();
		model.addAttribute("list", list);
		return "bookList";
	}
}
