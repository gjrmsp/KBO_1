package com.kbo.s1.rb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rankBatter/**")
public class RankBatterController {
	
	@Autowired
	private RankBatterService rankBatterService;
	
	@GetMapping("rankBatterList")
	public void getList(RankBatterDTO rankBatterDTO, Model model) throws Exception {
		List<RankBatterDTO> ar = rankBatterService.getList(rankBatterDTO);
		model.addAttribute("list", ar);
	}

	@GetMapping("rankBatterSelect")
	public ModelAndView getSelect(RankBatterDTO rankBatterDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		rankBatterDTO = rankBatterService.getSelect(rankBatterDTO);
		mv.addObject("dto", rankBatterDTO);
		mv.setViewName("rankBatter/rankBetterSelect");
		return mv;
	}
	
	@GetMapping("rankBatterInsert")
	public ModelAndView setInsert() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("rankBatter/rankBatterInsert");
		mv.addObject("batterRank", "batterRank");
		return mv;
	}
	
	@PostMapping("rankBatterInsert")
	public String setInsert(RankBatterDTO rankBatterDTO, Model model) throws Exception {
		int result = rankBatterService.setInsert(rankBatterDTO);
		String message = "등록 실패";
		
		if(result>0) {
			message = "등록 성공";
		}
		
		model.addAttribute("msg", message);
		model.addAttribute("path", "./rankBatterList");
		return "common/commonResult";
	}
	
	@GetMapping("rankBatterUpdate")
	public ModelAndView setUpdate(RankBatterDTO rankBatterDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		rankBatterDTO = rankBatterService.getSelect(rankBatterDTO);
		mv.addObject("dto", rankBatterDTO);
		mv.setViewName("rankBatter/rankBatterUpdate");
		return mv;
	}

	@PostMapping("rankBatterUpdate")
	public ModelAndView setUpdate(RankBatterDTO rankBatterDTO, ModelAndView mv) throws Exception {
		int result = rankBatterService.setUpdate(rankBatterDTO);
		
		if(result>0) {
			//성공하면 리스트로 이동
			mv.setViewName("redirect:./rankBatterList");
		} else {
			//실패하면 수정 실패 alert, 리스트로 이동
			mv.addObject("msg", "수정 실패");
			mv.addObject("path", "./rankBatterList");
			mv.setViewName("common/commonResult");
		}
		return mv;
	}

	@PostMapping("rankBatterDelete")
	public ModelAndView setDelete(RankBatterDTO rankBatterDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = rankBatterService.setDelete(rankBatterDTO);
		String message = "삭제 실패";
		String path = "./rankBatterList";
		
		if(result>0) {
			message = "삭제 성공";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", path);
		mv.setViewName("common/commonResult");
		return mv;
	}
}
