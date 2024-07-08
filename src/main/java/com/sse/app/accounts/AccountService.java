package com.sse.app.accounts;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;

	public int add(AccountDTO accountDTO) throws Exception {

//      현재 날짜
		Calendar ca = Calendar.getInstance();
//      중복 안되게 현재 날짜에서 밀리세컨즈까지 빼오는거
		long num = ca.getTimeInMillis();
//      db의 bank의 계좌번호 데이터타입이 문자열이라 문자열로 바꿔주는거
		String bank = String.valueOf(num);

		accountDTO.setBank_id(bank);

		return accountDAO.add(accountDTO);

	}

}
