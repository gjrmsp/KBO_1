package com.kbo.s1.rt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankTeamService {

	@Autowired
	private RankTeamDAO rankTeamDAO;
	
	public List<RankTeamDTO> getList(RankTeamDTO rankTeamDTO) throws Exception {
		return rankTeamDAO.getList();
	}
	
	public RankTeamDTO getSelect(RankTeamDTO rankTeamDTO) throws Exception {
		return rankTeamDAO.getSelect(rankTeamDTO);
	}
	
	public int setInsert(RankTeamDTO rankTeamDTO) throws Exception {
		return rankTeamDAO.setInsert(rankTeamDTO);
	}
	
	public int setUpdate(RankTeamDTO rankTeamDTO) throws Exception {
		return rankTeamDAO.setUpdate(rankTeamDTO);
	}
	
	public int setDelete(RankTeamDTO rankTeamDTO) throws Exception {
		return rankTeamDAO.setDelete(rankTeamDTO);
	}
}
