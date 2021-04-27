package com.kbo.s1.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kbo.s1.email.Email;
import com.kbo.s1.email.EmailSender;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private EmailSender emailSender;
	@Autowired
	private Email email;
	
	//회원 가입
	@GetMapping("memberJoin")
	public void memberJoin() throws Exception {}

	@PostMapping("memberJoin")
	public String memberJoin(MemberDTO memberDTO, HttpSession session, Model model) throws Exception {
		int result = memberService.memberJoin(memberDTO, session);
		String message = "회원가입 실패";
		String path = "./memberJoin";

		if(result>0) {
			message = "회원가입 성공";
			path = "../";
		}
		
		model.addAttribute("msg", message);
		model.addAttribute("path", path);
		return "common/commonResult";
	}
	
	@RequestMapping("memberJoinCheck")
	public void memberJoinCheck() throws Exception {}
	
	@RequestMapping("memberSuccess")
	public void memberSuccess() throws Exception {}
	
	//ID 중복 확인
	@GetMapping("memberIdCheck")
	public String memberIdCheck(MemberDTO memberDTO, Model model) throws Exception {
		memberDTO = memberService.memberIdCheck(memberDTO);
		String result = "N";
		
		if(memberDTO == null) {
			result = "Y";
		}
		
		model.addAttribute("result", result);
		return "common/ajaxResult";
	}

	//로그인
	@GetMapping("memberLogin")
	public void memberLogin() throws Exception {}
	
	@PostMapping("memberLogin")
	public String memberLogin(MemberDTO memberDTO, HttpSession session) throws Exception {
		memberDTO = memberService.memberLogin(memberDTO);
		session.setAttribute("member", memberDTO);
		return "redirect:../";
	}
	
	//ID 찾기
	@GetMapping("memberFindId")
	public void memberFindId() throws Exception {}
	
	@PostMapping("memberFindId")
	public ModelAndView memberFindId(MemberDTO memberDTO, ModelAndView mv) throws Exception {
		memberDTO = memberService.memberFindId(memberDTO);
		String message = "등록된 아이디가 없습니다";
		String id = "./memberFindId";

		if(memberDTO != null) {
			id = memberDTO.getId();
		}
		
		mv.addObject("msg", message);
		mv.addObject("id", id);
		return mv;
	}
	
	//PW 찾기
	@GetMapping
	public void memberFindPw() throws Exception {}
	
	@PostMapping
	public ModelAndView memberFindPw(MemberDTO memberDTO, ModelAndView mv) throws Exception {
		memberDTO = memberService.memberFindPw(memberDTO);
		
		if(memberDTO != null) {
            email.setContent("비밀번호는 "+memberDTO.getPw()+" 입니다.");
            email.setReceiver(memberDTO.getEmail());
            email.setSubject(memberDTO.getName()+"님 비밀번호 찾기 메일입니다.");
            emailSender.SendEmail(email);
            mv = new ModelAndView("redirect:/login.do");
            return mv;
		} else {
            mv = new ModelAndView("redirect:/logout.do");
            return mv;
		}
	}

	//로그아웃
	@RequestMapping("memberLogout")
	public String memberLogout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
	}
	
	//회원 페이지
	@RequestMapping("memberPage")
	public void memberPage() throws Exception {}
	
	//정보 수정
	@GetMapping("memberUpdate")
	public void memberUpdate() throws Exception {}
	
	@PostMapping("memberUpdate")
	public String memberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception {
		int result = memberService.memberUpdate(memberDTO);
	
		if(result>0) {
			session.setAttribute("member", memberDTO);
		}
		
		return "redirect:../";
	}

	//회원 탈퇴
	@RequestMapping("memberDelete")
	public String memberDelete(HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		int result = memberService.memberDelete(memberDTO, session);
		session.invalidate();
		return "redirect:../";
	}

}
