package com.sse.app.notice;

import java.sql.Date;

public class NoticeDTO {
	private Long BoardNum;
	private String BoardWriter;
	private String BoardTitle;
	private Date CreateDate;
	private Date UpdateDate;
	private Long BoardHit;
	private String BoardContents;
	private String BoardCategory;

	public Long getBoardNum() {
		return BoardNum;
	}

	public void setBoardNum(Long boardNum) {
		BoardNum = boardNum;
	}

	public String getBoardWriter() {
		return BoardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		BoardWriter = boardWriter;
	}

	public String getBoardTitle() {
		return BoardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		BoardTitle = boardTitle;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public Date getUpdateDate() {
		return UpdateDate;
	}

	public void setUpdateDate(Date updateDate) {
		UpdateDate = updateDate;
	}

	public Long getBoardHit() {
		return BoardHit;
	}

	public void setBoardHit(Long boardHit) {
		BoardHit = boardHit;
	}

	public String getBoardContents() {
		return BoardContents;
	}

	public void setBoardContents(String boardContents) {
		BoardContents = boardContents;
	}

	public String getBoardCategory() {
		return BoardCategory;
	}

	public void setBoardCategory(String boardCategory) {
		BoardCategory = boardCategory;
	}

}
