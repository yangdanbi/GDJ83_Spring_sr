package com.sse.app.boards;

import java.util.List;

import com.sse.app.util.Pager;

public interface BoardService {

//	list 가져오는 메서드
	public List<BoardDTO> getList(Pager pager) throws Exception;

//	글 추가 하는 메서드
	public int add(BoardDTO boardDTO) throws Exception;

//	글 수정 하는 메서드
	public int update(BoardDTO boardDTO) throws Exception;

//	글 삭제 하는 메서드
	public int delete(BoardDTO boardDTO) throws Exception;

//	글 하나 읽어오는 메서드
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;

}
