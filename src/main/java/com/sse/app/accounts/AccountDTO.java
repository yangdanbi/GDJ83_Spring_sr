package com.sse.app.accounts;

import com.sse.app.members.MemberDTO;
import com.sse.app.products.ProductDTO;

public class AccountDTO {

	private String bank_id;
	private String member_id;
	private Integer item_id;
	private String open_date;
	private String bank_pw;
	private Integer balance;
	private MemberDTO memberDTO;
	private ProductDTO productDTO;

	public MemberDTO getMemberDTO() {
		return memberDTO;
	}

	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public String getBank_id() {
		return bank_id;
	}

	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public Integer getItem_id() {
		return item_id;
	}

	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}

	public String getOpen_date() {
		return open_date;
	}

	public void setOpen_date(String open_date) {
		this.open_date = open_date;
	}

	public String getBank_pw() {
		return bank_pw;
	}

	public void setBank_pw(String bank_pw) {
		this.bank_pw = bank_pw;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

}
