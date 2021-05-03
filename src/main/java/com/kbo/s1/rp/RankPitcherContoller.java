package com.kbo.s1.rp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rankPitcher/**")
public class RankPitcherContoller {
	
	@Autowired
	private RankPitcherService rankPitcherService;

	@GetMapping("rankPitcherList")
	public void getList(RankPitcherDTO rankPitcherDTO, Model model) throws Exception {
		List<RankPitcherDTO> ar = rankPitcherService.getList(rankPitcherDTO);
		model.addAttribute("list", ar);
	}
	
	@GetMapping("rankPitcherSelect")
	public ModelAndView getSelect(RankPitcherDTO rankPitcherDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		rankPitcherDTO = rankPitcherService.getSelect(rankPitcherDTO);
		mv.addObject("dto", rankPitcherDTO);
		mv.setViewName("rankPitcher/rankPitcherSelect");
		return mv;
	}
	
	@GetMapping("rankPitcherInsert")
	public ModelAndView setInsert() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("rankPitcher/rankPitcherInsert");
		mv.addObject("PitcherRank", "PitcherRank");
		return mv;
	}
	
	@PostMapping("rankPitcherInsert")
	public String setInsert(RankPitcherDTO rankPitcherDTO, Model model) throws Exception {
		int result = rankPitcherService.setInsert(rankPitcherDTO);
		String message = "등록 실패";
		
		if(result>0) {
			message = "등록 성공";
		}
		
		model.addAttribute("msg", message);
		model.addAttribute("path", "./rankPitcherList");
		return "common/commonResult";
	}
	
	@GetMapping("rankPitcherUpdate")
	public ModelAndView setUpdate(RankPitcherDTO rankPitcherDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		rankPitcherDTO = rankPitcherService.getSelect(rankPitcherDTO);
		mv.addObject("dto", rankPitcherDTO);
		mv.setViewName("rankPitcher/rankPitcherUpdate");
		return mv;
	}

	@PostMapping("rankPitcherUpdate")
	public ModelAndView setUpdate(RankPitcherDTO rankPitcherDTO, ModelAndView mv) throws Exception {
		int result = rankPitcherService.setUpdate(rankPitcherDTO);
		
		if(result>0) {
			//성공하면 리스트로 이동
			mv.setViewName("redirect:./rankPitcherList");
		} else {
			//실패하면 수정 실패 alert, 리스트로 이동
			mv.addObject("msg", "수정 실패");
			mv.addObject("path", "./rankPitcherList");
			mv.setViewName("common/commonResult");
		}
		return mv;
	}

	@PostMapping("rankPitcherDelete")
	public ModelAndView setDelete(RankPitcherDTO rankPitcherDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = rankPitcherService.setDelete(rankPitcherDTO);
		String message = "삭제 실패";
		String path = "./rankPitcherList";
		
		if(result>0) {
			message = "삭제 성공";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", path);
		mv.setViewName("common/commonResult");
		return mv;
	}
}
