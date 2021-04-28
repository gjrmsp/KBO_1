package com.kbo.s1.board;

import java.util.List;

import com.kbo.s1.util.Pager;

public interface BoardDAO {

	//List
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	//전체 글의 갯수
	public long getTotalCount(Pager pager) throws Exception;
	
	//글 조회
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception;
	
	//글 추가
	//public int setInsert(BoardDTO boardDTO) throws Exception;
	
	//글 수정
	//public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	//글 삭제
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	//조회 수
	public int setHitUpdate(BoardDTO boardDTO) throws Exception;

}