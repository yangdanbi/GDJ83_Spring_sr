package com.sse.app.notice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;

	public int add(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.add(noticeDTO);
	}

	public void getList(Long page) throws Exception {

		if (page == null) {
			page = 1L;
		}

//		내가 기본적으로 한 화면에 보여주고 싶은 행의 갯수 10개
		Long perPage = 10L;

//		보여줄 db의 시작행, 마지막행 구하기
		Long startRow = 1 + (perPage * (page - 1));
		Long lastRow = page * perPage;

//		내가 보여줘야하는 총 행의 갯수
		Long totalCount = noticeDAO.countList();

		Long totalPage = 0L;

		if (totalCount % perPage != 0) {
			totalPage = totalCount / perPage + 1;
		} else {
			totalPage = totalCount / perPage;
		}

//		내가 정한 페이지 버튼의 갯수 
		Long perBlock = 5L;
		Long totalBlock = 0L;

		if (totalPage % perBlock != 0) {
			totalBlock = totalPage / perBlock + 1;
		} else {
			totalBlock = totalPage / perBlock;
		}

		Long curBlock = 0L;

		if (page % perBlock != 0) {
			curBlock = page / perBlock + 1;
		} else {
			curBlock = page / perBlock;
		}

		Long startNum = 1 + (perBlock * (curBlock - 1));
		Long lastNum = perBlock * curBlock;

		boolean pre = true;
		boolean nex = true;

		if (curBlock <= 1) {
			pre = false;
		}
		if (curBlock == totalBlock) {
			nex = false;
			lastNum = totalPage;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", startNum);
		map.put("lastNum", lastNum);

	}
}
