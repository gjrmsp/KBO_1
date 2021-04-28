package com.kbo.s1.board.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kbo.s1.board.BoardDTO;
import com.kbo.s1.board.BoardFileDTO;
import com.kbo.s1.util.Pager;

@Controller
@RequestMapping("/news/**")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping("newsList")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println(pager.getCurPage());
		List<BoardDTO> ar = newsService.getList(pager);
		mv.addObject("list", ar);
		mv.setViewName("board/imageList");
		mv.addObject("board", "news");
		mv.addObject("pager", pager);
		return mv;
	}

	@GetMapping("newsSelect")
	public ModelAndView getSelect(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = newsService.getSelect(boardDTO);
		mv.addObject("dto", boardDTO);
		mv.addObject("board", "news");
		mv.setViewName("board/boardSelect");
		return mv;
	}

	@GetMapping("newsInsert")
	public ModelAndView setInsert() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "news");
		return mv;
	}

	@PostMapping("newsInsert")
	public String setInsert(BoardDTO boardDTO, Model model, MultipartFile [] files) throws Exception {
		int result = newsService.setInsert(boardDTO, files);
		String message="등록 실패";
		
		if(result>0) {
			message="등록 성공";
		}
		
		model.addAttribute("msg", message);
		model.addAttribute("path", "./newsList");
		return "common/commonResult";
	}

	@GetMapping("newsUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = newsService.getSelect(boardDTO);
		mv.addObject("dto", boardDTO);
		mv.addObject("board", "news");
		mv.setViewName("board/boardUpdate");
		return mv;
	}

	@PostMapping("newsUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv, MultipartFile [] files) throws Exception {
		int result = newsService.setUpdate(boardDTO, files);
		
		if(result>0) {
			//성공하면 리스트로 이동
			mv.setViewName("redirect:./newsList");
		} else {
			//실패하면 수정 실패 alert, 리스트로 이동
			mv.addObject("msg", "수정 실패");
			mv.addObject("path", "./newsList");
			mv.setViewName("common/commonResult");
		}

		return mv;
	}

	@PostMapping("newsDelete")
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = newsService.setDelete(boardDTO);
		String message = "삭제 실패";
		String path = "./newsList";
		
		if(result>0) {
			message = "삭제 성공";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", path);
		mv.setViewName("common/commonResult");
		return mv;
	}

	@GetMapping("fileDelete")
	public ModelAndView setFileDelete(BoardFileDTO boardFileDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = newsService.setFileDelete(boardFileDTO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}

	@PostMapping("summerFileUpload")
	public ModelAndView setSummerFileUpload(MultipartFile file) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("Summer File Upload");
		System.out.println(file.getOriginalFilename());
		String fileName = newsService.setSummerFileUpload(file);
		fileName = "../resources/upload/news/"+fileName;
		mv.addObject("result", fileName);
		mv.setViewName("common/ajaxResult");
		return mv;
	}

	@PostMapping("summerFileDelete")
	public ModelAndView setSummerFileDelete(String fileName) throws Exception {
		ModelAndView mv = new ModelAndView();
		boolean result = newsService.setSummerFileDelete(fileName);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
}
