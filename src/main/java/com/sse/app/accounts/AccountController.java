package com.sse.app.accounts;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sse.app.members.MemberDTO;

@Controller
@RequestMapping(value = "/account/*")
public class AccountController {

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add(AccountDTO accountDTO, Model model) {

		model.addAttribute("account", accountDTO);

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(AccountDTO accountDTO, HttpSession session) {

//		현재 날짜
		Calendar ca = Calendar.getInstance();
//		중복 안되게 현재 날짜에서 밀리세컨즈까지 빼오는거
		long num = ca.getTimeInMillis();
//		db의 bank의 계좌번호 데이터타입이 문자열이라 문자열로 바꿔주는거
		String bank = String.valueOf(num);

		accountDTO = accountDTO.setBank_id(bank);
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		accountDTO.setMember_id(memberDTO.getMember_id());

	}

}
