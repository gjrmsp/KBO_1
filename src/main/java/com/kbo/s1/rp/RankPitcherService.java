package com.kbo.s1.rp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankPitcherService {
	
	@Autowired
	private RankPitcherDAO rankPitcherDAO;

	public List<RankPitcherDTO> getList(RankPitcherDTO rankPitcherDTO) throws Exception {
		return rankPitcherDAO.getList();
	}
	
	public RankPitcherDTO getSelect(RankPitcherDTO rankPitcherDTO) throws Exception {
		return rankPitcherDAO.getSelect(rankPitcherDTO);
	}
	
	public int setInsert(RankPitcherDTO rankPitcherDTO) throws Exception {
		return rankPitcherDAO.setInsert(rankPitcherDTO);
	}
	
	public int setUpdate(RankPitcherDTO rankPitcherDTO) throws Exception {
		return rankPitcherDAO.setUpdate(rankPitcherDTO);
	}
	
	public int setDelete(RankPitcherDTO rankPitcherDTO) throws Exception {
		return rankPitcherDAO.setDelete(rankPitcherDTO);
	}
}
