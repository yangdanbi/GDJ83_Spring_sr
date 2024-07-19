package com.sse.app.members;

import java.util.List;

import com.sse.app.accounts.AccountDTO;

public class MemberDTO {

	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_phone;
	private String member_mail;
	private List<AccountDTO> dtos;
	private MemberFileDTO memberFileDTO;

	public MemberFileDTO getMemberFileDTO() {
		return memberFileDTO;
	}

	public void setMemberFileDTO(MemberFileDTO memberFileDTO) {
		this.memberFileDTO = memberFileDTO;
	}

	public List<AccountDTO> getDtos() {
		return dtos;
	}

	public void setDtos(List<AccountDTO> dtos) {
		this.dtos = dtos;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_mail() {
		return member_mail;
	}

	public void setMember_mail(String member_mail) {
		this.member_mail = member_mail;
	}

}
