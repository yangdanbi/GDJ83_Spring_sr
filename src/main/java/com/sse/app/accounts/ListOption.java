package com.sse.app.accounts;

import java.sql.Date;

public class ListOption {

	private String bank_id;
	private Integer order;
	private Integer view;
	private Date timepoint;

	public Date getTimepoint() {
		return timepoint;
	}

	public void setTimepoint(Date timepoint) {
		this.timepoint = timepoint;
	}

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	public String getBank_id() {
		return bank_id;
	}

	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

}
