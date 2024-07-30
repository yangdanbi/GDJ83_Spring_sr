package com.sse.app.interceptors;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sse.app.boards.BoardDTO;
import com.sse.app.members.MemberDTO;

public class WriterInterceptor extends HandlerInterceptorAdapter {
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String method = request.getMethod();
		// post일때 밑에 안하고 get일때만 실행
		// get/post일때 검증하는 법
		if (method.toUpperCase().equals("POST")) {
			return;
		}
		MemberDTO memberDTO = (MemberDTO) request.getSession().getAttribute("member");
		Map<String, Object> map = modelAndView.getModel();

		Iterator<String> it = map.keySet().iterator();

		while (it.hasNext()) {
			System.out.println(it.next());

		}
		// 작성자랑 로그인 한 사용자가 같은지 검증
		BoardDTO boardDTO = (BoardDTO) map.get("dto");

		if (!boardDTO.getBoardWriter().equals(memberDTO.getMember_id())) {
			modelAndView.setViewName("commons/message");
			modelAndView.addObject("result", "작성자만 가능합니다.");
			modelAndView.addObject("url", "/");

			// modelAndView.setViewName("redirect:/");
		}
	}

}
