package com.sse.app.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Long page) {

	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		return "/notice/write";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(NoticeDTO noticeDTO, Model model) throws Exception {

		int num = noticeService.add(noticeDTO);

		if (num > 0) {

			model.addAttribute("result", "게시글을 등록했습니다");
			model.addAttribute("url", "/notice/list");
			return "/commons/message";

		}
		model.addAttribute("result", "게시글 등록에 실패했습니다");
		model.addAttribute("url", "/notice/list");
		return "/commons/message";

	}

}
