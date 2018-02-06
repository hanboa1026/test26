package ksmart.project.test26;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import ksmart.project.test26.service.Member;
import ksmart.project.test26.service.MemberDao;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;

	// 로그인 폼 요청
	@RequestMapping(value="/log/login", method=RequestMethod.GET)
	public String Login(Model model) {		
		return "log/login";
	}
	
	// 로그인 요청
	@RequestMapping(value = "/log/loginAction", method = RequestMethod.POST)
	public String login(HttpSession session, Member member){
		
	
	//	 1. logger.debug(member)
	//	 2. dao(member)
		Member member1 = memberDao.login(member);

	//	 3. mapper....
	//	 4. 결과값이 null이면 redirect : login
		if(member1 == null) {
			return "redirect:/log/login";
		} else {
			session.setAttribute("loginMember", member1);
		}
	//	 5. member -> session.setAttribute("loginMember",member)
	//	 6. redirect : index or mypage
	//	
	//	 login / logout
	//	 1명 : 회원가입...
	//	 나머지 인증단계를 적용해야할 Countroller..
	//	
		return "redirect:/";
	}
	
	
}
