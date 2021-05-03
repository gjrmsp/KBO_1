package com.kbo.s1.rb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankBatterService {
	
	@Autowired
	private RankBatterDAO rankBatterDAO;

	public List<RankBatterDTO> getList(RankBatterDTO rankBatterDTO) throws Exception {
		return rankBatterDAO.getList();
	}
	
	public RankBatterDTO getSelect(RankBatterDTO rankBatterDTO) throws Exception {
		return rankBatterDAO.getSelect(rankBatterDTO);
	}
	
	public int setInsert(RankBatterDTO rankBatterDTO) throws Exception {
		return rankBatterDAO.setInsert(rankBatterDTO);
	}
	
	public int setUpdate(RankBatterDTO rankBatterDTO) throws Exception {
		return rankBatterDAO.setUpdate(rankBatterDTO);
	}
	
	public int setDelete(RankBatterDTO rankBatterDTO) throws Exception {
		return rankBatterDAO.setDelete(rankBatterDTO);
	}
}
