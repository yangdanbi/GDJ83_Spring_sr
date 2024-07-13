package com.sse.app.notice;

import java.util.List;
import java.util.Map;

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
	public void getList(Long page,String kind, String search,Model model) throws Exception{
		
		
		Map<String, Object> map =noticeService.getList(page,kind,search);
		model.addAttribute("map", map);
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(String write,Model model) throws Exception{
		model.addAttribute("write", write);
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
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public void getDetail(NoticeDTO noticeDTO,Model model) throws Exception {
		
		NoticeDTO dto =noticeService.getDetail(noticeDTO);
		
		model.addAttribute("dto",dto);
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String update(String write,Model model) {
		model.addAttribute("write", write);
		return "/notice/write";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(NoticeDTO noticeDTO,Model model) throws Exception {
		int num = noticeService.update(noticeDTO);
		if(num>0) {
			model.addAttribute("result", "수정 완료");
			model.addAttribute("url", "/notice/list");
			return "/commons/message";
		}
		model.addAttribute("result", "수정 실패");
		model.addAttribute("url", "/notice/list");
		return "/commons/message";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(NoticeDTO noticeDTO,Model model) throws Exception{
		int num = noticeService.delete(noticeDTO);
		
		if(num>0) {
			model.addAttribute("result", "삭제 완료");
			model.addAttribute("url", "/notice/list");
			return "/commons/message";
		}
		model.addAttribute("result", "삭제 실패");
		model.addAttribute("url", "/notice/list");
		return "/commons/message";
	}

}
