package com.sse.app.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;

	public int join(MemberDTO memberDTO) throws Exception {

		return memberDAO.join(memberDTO);

	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception {

		MemberDTO result = memberDAO.login(memberDTO);
		if (result != null) {
			if (result.getMember_pw().equals(memberDTO.getMember_pw())) {
				return result;
			} else {
				return null;
			}
		}
		return result;
	}
}