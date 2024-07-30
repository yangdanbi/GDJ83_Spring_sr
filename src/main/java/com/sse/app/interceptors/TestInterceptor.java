package com.sse.app.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//빈의 이름은 따로 주지않으면 CLASS명의 첫글자를 소문자로 바꾼것
//추상클래스
@Component
public class TestInterceptor extends HandlerInterceptorAdapter {
	// preHandle,postHandle 자주 사용

	// controller 진입전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub

		// return 이 true라면 다음 인터셉터나 controller로 보냄
		// return 이 false라면 진입을 막음
		System.out.println("Test Interceptor preHandle 진입");
		return true;
	}

	// controller 나갈때
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("Test Interceptor postHandle 진입");
	}

	// JSP 렌더링 후
	// 잘 안씀
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Test Interceptor afterCompletion 진입");

	}

}
