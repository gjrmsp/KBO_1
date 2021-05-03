package com.kbo.s1.rp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RankPitcherDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.kbo.s1.rp.RankPitcheDAO.";
	
	public List<RankPitcherDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList");
	}

	public RankPitcherDTO getSelect(RankPitcherDTO rankPitcherDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getSelect", rankPitcherDTO);
	}
	
	public int setInsert(RankPitcherDTO rankPitcherDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setInsert", rankPitcherDTO);
	}
	
	public int setUpdate(RankPitcherDTO rankPitcherDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", rankPitcherDTO);
	}
	
	public int setDelete(RankPitcherDTO rankPitcherDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", rankPitcherDTO);
	}
}
