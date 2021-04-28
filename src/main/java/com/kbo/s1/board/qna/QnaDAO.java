package com.kbo.s1.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kbo.s1.board.BoardDAO;
import com.kbo.s1.board.BoardDTO;
import com.kbo.s1.board.BoardFileDTO;
import com.kbo.s1.util.Pager;

@Repository
public class QnaDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.kbo.s1.board.qna.QnaDAO.";

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}

	@Override
	public long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getTotalCount", pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getSelect", boardDTO);
	}

	public int setInsert(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setInsert", boardDTO);
	}

	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
	}

	@Override
	public int setHitUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setHitUpdate", boardDTO);
	}

	public int setReply(QnaDTO qnaDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setReply", qnaDTO);
	}
	
	public int setReplyUpdate(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setReplyUpdate", qnaDTO);
	}

}
