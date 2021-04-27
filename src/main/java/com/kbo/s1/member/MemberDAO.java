package com.kbo.s1.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.kbo.s1.member.MemberDAO.";
	
	//회원 가입
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"memberJoin", memberDTO);
	}
	
	//ID 중복 체크
	public MemberDTO memberIdCheck(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"memberIdCheck", memberDTO);
	}

	//로그인
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"memberLogin", memberDTO);
	}
	
	//ID 찾기
	public MemberDTO memberFindId(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"memberFindId", memberDTO);
	}
	
	//PW 찾기
	public MemberDTO memberFindPw(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"memberFindPw", memberDTO);
	}
	
	//정보 수정
	public int memberUpdate(MemberDTO memberDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"memberUpdate", memberDTO);
	}
	
	//회원 탈퇴
	public int memberDelete(MemberDTO memberDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"memberDelete", memberDTO);
	}
}