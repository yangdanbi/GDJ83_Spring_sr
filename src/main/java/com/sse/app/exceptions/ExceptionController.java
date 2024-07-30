package com.sse.app.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice 예외를 전문적으로 처리하는 애들
//@RestControllerAdvice ajax 로 요청했을때 발생하는 에러처리(jsp안쓰고 프론트 백이 완전히 분리됐을 때 사용하면 됨)

@ControllerAdvice
public class ExceptionController {
	// 에러처리는 배포하기전에만 하면 됨 그 전엔 에러메세지 보고 수정해야하니까
	// null 에러 처리
	@ExceptionHandler(NullPointerException.class)
	public String exception1() {
		return "errors/error_404.jsp";
	}
}
