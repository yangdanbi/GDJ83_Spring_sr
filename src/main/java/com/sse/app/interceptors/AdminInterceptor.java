package com.sse.app.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sse.app.members.MemberDTO;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 로그인 한 사람중 관리자인지 아닌지 판단
		// 로그인 한 사람 정보가 필요해서 session
		MemberDTO memberDTO = (MemberDTO) request.getSession().getAttribute("member");
		// 로그인안하고 주소치고 들어오는 걸 방지
		// 로그인검증 intetceptor, filter넣어주면 if 필요x
		if (memberDTO == null) {
			// Redirect방식
			response.sendRedirect("/member/login");
			// false면 진입x
			return false;
		}
		// 여기까지온건 로그인은 했지만 관리자가 아님
		if (!memberDTO.getMember_id().equals("ydb")) {
			// url로 들어올 경우
			request.setAttribute("result", "권한이 없습니다.");
			request.setAttribute("url", "/");
			// forward 방식
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/message.jsp");
			view.forward(request, response);
			return false;

		}
		// 관리자가 맞으면 true
		return true;

	}

}
