package ksmart.project.test26;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
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
	
	 private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberDao memberDao;
	
	// 목록조회
	@RequestMapping(value="", method=RequestMethod.GET)
	public String memberList(Model model, HttpSession session) {
		if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
		List<Member> list = memberDao.selectMemberList();
		logger.debug("회원 목록{}", list);
		model.addAttribute("list",list);
		return "member/memberList";
	}
	
	// 하나정보 요청
	@RequestMapping(value="/member/memberInfo", method=RequestMethod.GET)
	public String memberSelectByNo(Model model, int memberNo) {
		logger.debug("회원 번호 {}번",memberNo); //회원 번호 ?번 출력
		model.addAttribute("member", memberDao.selectMemberByNo(memberNo));
		//멤버 정보를 model에 담아서 리턴
		return "member/memberInfo";
	}
	
	// 입력페이지 요청
	@RequestMapping(value="/member/memberAdd", method=RequestMethod.GET)
	public String memberInsert() {
		return "member/memberInsert";
	}
	
	// 입력처리 요청
	@RequestMapping(value="/member/memberAdd", method=RequestMethod.POST)
	public String memberInsert(Member member, HttpSession session) {
		logger.debug("회원 정보{}", member);
		memberDao.insertMember(member);
		return "home";
	}
	
	// 업데이트 정보요청
	@RequestMapping(value="/member/memberModify", method=RequestMethod.GET)
	public String memberUpdate(Model model,@RequestParam(value="memberNo", required=true)int memberNo) {	
		model.addAttribute("member", memberDao.selectMemberByNo(memberNo));
		return "member/memberUpdate";		
	}
	
	// 업데이트 처리요청
	@RequestMapping(value="/member/memberModify", method=RequestMethod.POST)
	public String memberUpdate(Member member) {
		logger.debug("회원 정보{}", member);
		memberDao.updateMember(member);
		return "redirect:/";	
	}
	
	// 삭제
	@RequestMapping(value="/member/memberRemove", method=RequestMethod.GET)
	public String memberDelete(Model model,@RequestParam(value="memberNo", required=true)int memberNo) {
		logger.debug("회원 번호 {}번",memberNo);
		memberDao.deleteMember(memberNo);
		return "/log/logOut";		
	}

	// 로그인 화면 요청
	@RequestMapping(value="/log/login", method=RequestMethod.GET)
	public String Login() {	
		 return "log/login";
	}
	
	// 로그인 요청
	@RequestMapping(value = "/log/loginAction", method = RequestMethod.POST)
	public String login(HttpSession session, Member member){
		logger.debug("회원 정보{}", member);
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
	
	// 로그아웃 요청
	@RequestMapping(value = "/log/logOut", method = RequestMethod.GET)
	public String logout(HttpSession session, Member member){
		logger.debug("회원 정보{}", member);
			session.invalidate();
		return "home";		
	}	
}
