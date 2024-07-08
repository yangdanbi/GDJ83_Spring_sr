package com.sse.app.accounts;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sse.app.members.MemberDTO;

@Controller
@RequestMapping(value = "/account/*")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add(AccountDTO accountDTO, Model model) throws Exception {

		model.addAttribute("account", accountDTO);

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(AccountDTO accountDTO, HttpSession session, Model model) throws Exception {

		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		accountDTO.setMember_id(memberDTO.getMember_id());

		int result = accountService.add(accountDTO);

		if (result > 0) {

			model.addAttribute("result", "가입 완료");
			model.addAttribute("url", "/");
		}

		return "/commons/message";
	}

}
