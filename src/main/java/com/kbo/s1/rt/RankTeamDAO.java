package com.kbo.s1.rt;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RankTeamDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.kbo.s1.rt.RankTeamDAO.";
	
	public List<RankTeamDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList");
	}

	public RankTeamDTO getSelect(RankTeamDTO rankTeamDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getSelect", rankTeamDTO);
	}
	
	public int setInsert(RankTeamDTO rankTeamDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setInsert", rankTeamDTO);
	}
	
	public int setUpdate(RankTeamDTO rankTeamDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", rankTeamDTO);
	}
	
	public int setDelete(RankTeamDTO rankTeamDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", rankTeamDTO);
	}
}