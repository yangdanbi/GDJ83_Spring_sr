package com.sse.app.boards.notices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sse.app.boards.BoardDAO;
import com.sse.app.boards.BoardDTO;
import com.sse.app.boards.BoardService;
import com.sse.app.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	@Qualifier("noticeDAO")
	private BoardDAO boardDAO;

	public int add(BoardDTO boardDTO) throws Exception {
		return boardDAO.add(boardDTO);
	}

	public List<BoardDTO> getList(Pager pager) throws Exception {

		pager.makeRow();
		Long totalCount = boardDAO.countList(pager);

		pager.makeNum(totalCount);

		return boardDAO.getList(pager);

	}

	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		int num = boardDAO.hit(boardDTO);
		return boardDAO.getDetail(boardDTO);
	}

	public int update(BoardDTO boardDTO) throws Exception {
		return boardDAO.update(boardDTO);
	}

	public int delete(BoardDTO boardDTO) throws Exception {
		return boardDAO.delete(boardDTO);
	}
}
