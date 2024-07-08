package com.sse.app.members;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sse.app.accounts.AccountDAO;
import com.sse.app.accounts.AccountDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private AccountDAO accountDAO;

	public int join(MemberDTO memberDTO) throws Exception {

		return memberDAO.join(memberDTO);

	}

	public Map<String, Object> login(MemberDTO memberDTO) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		MemberDTO result = memberDAO.login(memberDTO);
		if (result != null) {
			if (result.getMember_pw().equals(memberDTO.getMember_pw())) {
				List<AccountDTO> ar = accountDAO.list(memberDTO);
				map.put("member", result);
				map.put("accounts", ar);
				return map;
			} else {
				return null;
			}
		}
		return null;
	}

	public MemberDTO update(MemberDTO memberDTO) throws Exception {

		int num = memberDAO.update(memberDTO);

		if (num > 0) {
			memberDAO.login(memberDTO);
		}
		return memberDTO;
	}

	public int delete(MemberDTO memberDTO) throws Exception {
		return memberDAO.delete(memberDTO);

	}

}
