package com.sse.app.boards.notices;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sse.app.boards.BoardDAO;
import com.sse.app.boards.BoardDTO;
import com.sse.app.boards.BoardService;
import com.sse.app.files.FileDTO;
import com.sse.app.files.FileManager;
import com.sse.app.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	@Qualifier("noticeDAO")
	private BoardDAO boardDAO;
	@Autowired
	private FileManager fileManager;

	public int add(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {

		Long num = boardDAO.getNum();
		boardDTO.setBoardNum(num);
		int result = boardDAO.add(boardDTO);

		if (files == null) {
			return result;
		}

		ServletContext servletContext = session.getServletContext();
		String path = servletContext.getRealPath("resources/upload/notice");

		for (MultipartFile f : files) {

			if (f.isEmpty()) {
				continue;
			}

			String fileName = fileManager.fileSave(f, path);
			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
			noticeFileDTO.setBoardNum(num);
			noticeFileDTO.setFileName(fileName);
			noticeFileDTO.setOriName(f.getOriginalFilename());

			result = boardDAO.addFile(noticeFileDTO);

		}
		return result;
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

	public FileDTO fileDetail(FileDTO fileDTO) throws Exception {
		return boardDAO.fileDetail(fileDTO);
	}
}
