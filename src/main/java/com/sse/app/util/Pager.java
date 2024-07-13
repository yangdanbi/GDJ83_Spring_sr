package com.sse.app.util;

public class Pager {

	private String kind;
	private String search;
	private Long startRow;
	private Long lastRow;
	private Long viewPage;
	
	public Long getViewPage() {
		return viewPage;
	}

	public void setViewPage(Long viewPage) {
		this.viewPage = viewPage;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

}
