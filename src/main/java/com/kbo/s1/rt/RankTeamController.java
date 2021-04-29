package com.kbo.s1.rt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rankTeam/**")
public class RankTeamController {
	
	@Autowired
	private RankTeamService rankTeamService;
	
	@GetMapping("rankTeamList")
	public void getList(RankTeamDTO rankTeamDTO, Model model) throws Exception {
		List<RankTeamDTO> ar = rankTeamService.getList(rankTeamDTO);
		model.addAttribute("list", ar);
	}

	@GetMapping("rankTeamSelect")
	public ModelAndView getSelect(RankTeamDTO rankTeamDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		rankTeamDTO = rankTeamService.getSelect(rankTeamDTO);
		mv.addObject("dto", rankTeamDTO);
		mv.setViewName("rankTeam/rankTeamSelect");
		return mv;
	}
	
	@GetMapping("rankTeamInsert")
	public ModelAndView setInsert() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("rankTeam/rankTeamInsert");
		mv.addObject("teamRank", "teamRank");
		return mv;
	}

	@PostMapping("rankTeamInsert")
	public String setInsert(RankTeamDTO rankTeamDTO, Model model) throws Exception {
		int result = rankTeamService.setInsert(rankTeamDTO);
		String message = "등록 실패";
		
		if(result>0) {
			message = "등록 성공";
		}

		model.addAttribute("msg", message);
		model.addAttribute("path", "./rankTeamList");
		return "common/commonResult";
	}
	
	@GetMapping("rankTeamUpdate")
	public ModelAndView setUpdate(RankTeamDTO rankTeamDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		rankTeamDTO = rankTeamService.getSelect(rankTeamDTO);
		mv.addObject("dto", rankTeamDTO);
		mv.setViewName("rankTeam/rankTeamUpdate");
		return mv;
	}

	@PostMapping("rankTeamUpdate")
	public ModelAndView setUpdate(RankTeamDTO rankTeamDTO, ModelAndView mv) throws Exception {
		int result = rankTeamService.setUpdate(rankTeamDTO);
		
		if(result>0) {
			//성공하면 리스트로 이동
			mv.setViewName("redirect:./rankTeamList");
		} else {
			//실패하면 수정 실패 alert, 리스트로 이동
			mv.addObject("msg", "수정 실패");
			mv.addObject("path", "./rankTeamList");
			mv.setViewName("common/commonResult");
		}
		return mv;
	}

	@PostMapping("rankTeamDelete")
	public ModelAndView setDelete(RankTeamDTO rankTeamDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = rankTeamService.setDelete(rankTeamDTO);
		String message = "삭제 실패";
		String path = "./rankTeamList";
		
		if(result>0) {
			message = "삭제 성공";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", path);
		mv.setViewName("common/commonResult");
		return mv;
	}
}