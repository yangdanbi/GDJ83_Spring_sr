package com.sse.app.members;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void joinPage() throws Exception {

	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String joinPage(Model model, MemberDTO memberDTO) throws Exception {

		int num = memberService.join(memberDTO);
		String url = "";

		if (num > 0) {

			url = "/commons/message";
			model.addAttribute("result", "회원 가입 됐습니다");
			model.addAttribute("url", "/");

		}

		return url;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void lonInPage(Model model,
			@CookieValue(name = "remember", required = false, defaultValue = "") String value) throws Exception {

		model.addAttribute("id", value);

		// Cookie[] cookies = request.getCookies();
//
//		for (Cookie c : cookies) {
//			if (c.getName().equals("remember")) {
//				request.setAttribute("id", c.getValue());
//			}
//		}
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String lonInPage(String remember, MemberDTO memberDTO, Model model, HttpServletResponse response,
			HttpSession session) throws Exception {

		if (remember != null) {
			Cookie cookie = new Cookie("remember", memberDTO.getMember_id());
			cookie.setMaxAge(60 * 60);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}

		memberDTO = memberService.login(memberDTO);
		String url = "/commons/message";

		if (memberDTO != null) {

			session.setAttribute("member", memberDTO);

			model.addAttribute("result", "로그인 성공");
			model.addAttribute("url", "/");

		} else {
			model.addAttribute("result", "로그인 실패");
			model.addAttribute("url", "/member/login");
		}

		return url;

	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		session.invalidate();
		return "redirect:/";
	}

}