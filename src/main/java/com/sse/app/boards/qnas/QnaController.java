package com.sse.app.boards.qnas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@GetMapping("list")
	public String getList() throws Exception {
		return "board/list";
	}

	@GetMapping("detail")
	public String getDetail() throws Exception {
		return "board/detail";
	}

	@GetMapping("add")
	public String add() throws Exception {
		return "board/write";
	}

	@GetMapping("update")
	public String update() throws Exception {
		return "board/write";
	}

}
