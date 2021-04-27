package com.kbo.s1.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	//회원 가입
	public int memberJoin(MemberDTO memberDTO, HttpSession session) throws Exception {
		return memberDAO.memberJoin(memberDTO);
	}
	
	//ID 중복 체크
	public MemberDTO memberIdCheck(MemberDTO memberDTO) throws Exception {
		return memberDAO.memberIdCheck(memberDTO);
	}
	
	//로그인
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		return memberDAO.memberLogin(memberDTO);
	}
	
	//ID 찾기
	public MemberDTO memberFindId(MemberDTO memberDTO) throws Exception {
		return memberDAO.memberFindId(memberDTO);
	}
	
	//PW 찾기
	public MemberDTO memberFindPw(MemberDTO memberDTO) throws Exception {
		return memberDAO.memberFindPw(memberDTO);
	}
	
	//정보 수정
	public int memberUpdate(MemberDTO memberDTO) throws Exception {
		return memberDAO.memberUpdate(memberDTO);
	}
	
	//회원 탈퇴
	public int memberDelete(MemberDTO memberDTO, HttpSession session) throws Exception {
		return memberDAO.memberDelete(memberDTO);
	}
}
