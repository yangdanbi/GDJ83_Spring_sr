package com.sse.app.boards.notices;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sse.app.boards.BoardDAO;
import com.sse.app.boards.BoardDTO;
import com.sse.app.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.sse.app.boards.notices.NoticeDAO.";

	public int add(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", boardDTO);
	}

	public Long countList(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "countList", pager);
	}

	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}

	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getDetail", boardDTO);
	}

	public int hit(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "hit", boardDTO);
	}

	public int update(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", boardDTO);
	}

	public int delete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", boardDTO);
	}

}
