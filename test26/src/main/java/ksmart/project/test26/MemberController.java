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
	
	// 紐⑸줉議고쉶
	@RequestMapping(value="", method=RequestMethod.GET)
	public String memberList(Model model, HttpSession session) {
		if(session.getAttribute("loginMember") == null ) {
			return "redirect:/log/login"; 
		}
		List<Member> list = memberDao.selectMemberList();
		logger.debug("�쉶�썝 紐⑸줉{}", list);
		model.addAttribute("list",list);
		return "member/memberList";
	}
	
	// �븯�굹�젙蹂� �슂泥�
	@RequestMapping(value="/member/memberInfo", method=RequestMethod.GET)
	public String memberSelectByNo(Model model, int memberNo) {
		logger.debug("�쉶�썝 踰덊샇 {}踰�",memberNo); //�쉶�썝 踰덊샇 ?踰� 異쒕젰
		model.addAttribute("member", memberDao.selectMemberByNo(memberNo));
		//硫ㅻ쾭 �젙蹂대�� model�뿉 �떞�븘�꽌 由ы꽩
		return "member/memberInfo";
	}
	
	// �엯�젰�럹�씠吏� �슂泥�
	@RequestMapping(value="/member/memberAdd", method=RequestMethod.GET)
	public String memberInsert() {
		return "member/memberInsert";
	}
	
	// �엯�젰泥섎━ �슂泥�
	@RequestMapping(value="/member/memberAdd", method=RequestMethod.POST)
	public String memberInsert(Member member, HttpSession session) {
		logger.debug("�쉶�썝 �젙蹂�{}", member);
		memberDao.insertMember(member);
		return "home";
	}
	
	// �뾽�뜲�씠�듃 �젙蹂댁슂泥�
	@RequestMapping(value="/member/memberModify", method=RequestMethod.GET)
	public String memberUpdate(Model model,@RequestParam(value="memberNo", required=true)int memberNo) {	
		model.addAttribute("member", memberDao.selectMemberByNo(memberNo));
		return "member/memberUpdate";		
	}
	
	// �뾽�뜲�씠�듃 泥섎━�슂泥�
	@RequestMapping(value="/member/memberModify", method=RequestMethod.POST)
	public String memberUpdate(Member member) {
		logger.debug("�쉶�썝 �젙蹂�{}", member);
		memberDao.updateMember(member);
		return "redirect:/";	
	}
	
	// �궘�젣
	@RequestMapping(value="/member/memberRemove", method=RequestMethod.GET)
	public String memberDelete(Model model,@RequestParam(value="memberNo", required=true)int memberNo) {
		logger.debug("�쉶�썝 踰덊샇 {}踰�",memberNo);
		memberDao.deleteMember(memberNo);
		return "/log/logOut";		
	}

	// 濡쒓렇�씤 �솕硫� �슂泥�
	@RequestMapping(value="/log/login", method=RequestMethod.GET)
	public String Login() {	
		 return "log/login";
	}
	
	// 濡쒓렇�씤 �슂泥�
	@RequestMapping(value = "/log/loginAction", method = RequestMethod.POST)
	public String login(HttpSession session, Member member){
		logger.debug("�쉶�썝 �젙蹂�{}", member);
	//	 1. logger.debug(member)
	//	 2. dao(member)
		Member member1 = memberDao.login(member);

	//	 3. mapper....
	//	 4. 寃곌낵媛믪씠 null�씠硫� redirect : login
		if(member1 == null) {
			return "redirect:/log/login";
		} else {
			session.setAttribute("loginMember", member1);
		}
	//	 5. member -> session.setAttribute("loginMember",member)
	//	 6. redirect : index or mypage
	//	
	//	 login / logout
	//	 1紐� : �쉶�썝媛��엯...
	//	 �굹癒몄� �씤利앸떒怨꾨�� �쟻�슜�빐�빞�븷 Countroller..
	//	
		return "redirect:/";
	}
	
	// 濡쒓렇�븘�썐 �슂泥�
	@RequestMapping(value = "/log/logOut", method = RequestMethod.GET)
	public String logout(HttpSession session, Member member){
		logger.debug("�쉶�썝 �젙蹂�{}", member);
			session.invalidate();
		return "redirect:/";		
	}	
}
