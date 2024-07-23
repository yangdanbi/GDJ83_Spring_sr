package com.sse.app.boards.qnas;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sse.app.boards.BoardDTO;
import com.sse.app.boards.BoardService;
import com.sse.app.files.FileDTO;
import com.sse.app.files.FileManager;
import com.sse.app.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private FileManager fileManager;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {

//		1.rownum 계산
		pager.makeRow();
//		2. 페이징 계산
		pager.makeNum(qnaDAO.countList(pager));
		return qnaDAO.getList(pager);
	}

	@Override
	public int add(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		Long num = qnaDAO.getNum();
		boardDTO.setBoardNum(num);
		int result = qnaDAO.add(boardDTO);

		if (files == null) {
			return result;
		}

		ServletContext servletContext = session.getServletContext();
		String path = servletContext.getRealPath("resources/upload/qna");

		for (MultipartFile f : files) {

			if (f.isEmpty()) {
				continue;
			}

			String fileName = fileManager.fileSave(f, path);
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setBoardNum(num);
			qnaFileDTO.setFileName(fileName);
			qnaFileDTO.setOriName(f.getOriginalFilename());

			result = qnaDAO.addFile(qnaFileDTO);

		}
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.delete(boardDTO);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		int num = qnaDAO.hit(boardDTO);
		return qnaDAO.getDetail(boardDTO);
	}

	public int reply(QnaDTO qnaDTO, HttpSession session, MultipartFile[] files) throws Exception {

		QnaDTO parent = (QnaDTO) qnaDAO.getDetail(qnaDTO);
//		1. step을 1씩 업데이트
		int result = qnaDAO.replyUpdate(parent);

//		2. 답글의 ref,step,depth의 값을 넣어주기
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep() + 1);
		qnaDTO.setDepth(parent.getDepth() + 1);

		result = qnaDAO.reply(qnaDTO);

		// 파일 저장
		String path = session.getServletContext().getRealPath("resources/upload/qna");

		if (files == null) {
			return result;
		}

		for (MultipartFile f : files) {
			if (f.isEmpty()) {
				continue;
			}

			String fileName = fileManager.fileSave(f, path);
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setBoardNum(qnaDTO.getBoardNum());
			qnaFileDTO.setFileName(fileName);
			qnaFileDTO.setOriName(f.getOriginalFilename());
			result = qnaDAO.addFile(qnaFileDTO);
		}
		return result;

	}

	public FileDTO fileDetail(FileDTO fileDTO) throws Exception {
		return qnaDAO.fileDetail(fileDTO);
	}

}
