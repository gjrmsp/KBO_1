package com.kbo.s1.rb;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RankBatterDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.kbo.s1.rb.RankBatterDAO.";
	
	public List<RankBatterDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList");
	}

	public RankBatterDTO getSelect(RankBatterDTO rankBatterDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getSelect", rankBatterDTO);
	}
	
	public int setInsert(RankBatterDTO rankBatterDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setInsert", rankBatterDTO);
	}
	
	public int setUpdate(RankBatterDTO rankBatterDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", rankBatterDTO);
	}
	
	public int setDelete(RankBatterDTO rankBatterDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", rankBatterDTO);
	}
}
