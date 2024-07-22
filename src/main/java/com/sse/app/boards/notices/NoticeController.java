package com.sse.app.boards.notices;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sse.app.boards.BoardDTO;
import com.sse.app.util.Pager;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@ModelAttribute("board")
	public String getBoard() {
		return "공지사항";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Model model, Pager pager) throws Exception {

		List<BoardDTO> list = noticeService.getList(pager);

		model.addAttribute("pager", pager);
		model.addAttribute("list", list);
		return "/board/list";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add(String write, Model model, ModelAndView mv) throws Exception {
		mv.setViewName("/board/write");
		model.addAttribute("write", write);
		return mv;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(NoticeDTO noticeDTO, Model model, MultipartFile[] files, HttpSession session) throws Exception {

		int num = noticeService.add(noticeDTO, files, session);

		if (num > 0) {

			model.addAttribute("result", "게시글을 등록했습니다");
			model.addAttribute("url", "/notice/list");
			return "/commons/message";

		}
		model.addAttribute("result", "게시글 등록에 실패했습니다");
		model.addAttribute("url", "/notice/list");
		return "/commons/message";

	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(NoticeDTO noticeDTO, Model model) throws Exception {

		BoardDTO dto = noticeService.getDetail(noticeDTO);

		model.addAttribute("dto", dto);
		return "/board/detail";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(String write, Model model, NoticeDTO noticeDTO) throws Exception {
		BoardDTO boardDTO = noticeService.getDetail(noticeDTO);
		model.addAttribute("dto", boardDTO);
		return "/board/write";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO, Model model) throws Exception {
		int num = noticeService.update(noticeDTO);
		if (num > 0) {
			model.addAttribute("result", "수정 완료");
			model.addAttribute("url", "/notice/list");
			return "/commons/message";
		}
		model.addAttribute("result", "수정 실패");
		model.addAttribute("url", "/notice/list");
		return "/commons/message";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(NoticeDTO noticeDTO, Model model) throws Exception {
		int num = noticeService.delete(noticeDTO);

		if (num > 0) {
			model.addAttribute("result", "삭제 완료");
			model.addAttribute("url", "/notice/list");
			return "/commons/message";
		}
		model.addAttribute("result", "삭제 실패");
		model.addAttribute("url", "/notice/list");
		return "/commons/message";
	}

}
