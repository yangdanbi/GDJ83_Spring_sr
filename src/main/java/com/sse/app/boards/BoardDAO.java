package com.sse.app.boards;

import java.util.List;

import com.sse.app.files.FileDTO;
import com.sse.app.util.Pager;

public interface BoardDAO {

//	NoticeDAO, QnaDAO가 같은 메서드를 쓰기 위해

//	함수 선언시 public,abstract 생략 가능

//	필요한 데이터의 총 행의 갯수 구해오는 메서드
	public Long countList(Pager pager) throws Exception;

//	list 가져오는 메서드
	public List<BoardDTO> getList(Pager pager) throws Exception;

//	글번호 가져오는 메서드
	public Long getNum() throws Exception;

//	파일 정보 db에 저장하는 메서드
	public int addFile(BoardFileDTO boardFileDTO) throws Exception;

//	글 추가 하는 메서드
	public int add(BoardDTO boardDTO) throws Exception;

//	글 수정 하는 메서드
	public int update(BoardDTO boardDTO) throws Exception;

//	글 삭제 하는 메서드
	public int delete(BoardDTO boardDTO) throws Exception;

//	글 하나 읽어오는 메서드
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;

//	조회수 증가시키는 메서드
	public int hit(BoardDTO boardDTO) throws Exception;

//	파일 다운로드 하는 메서드
	public FileDTO fileDetail(FileDTO fileDTO) throws Exception;
}
