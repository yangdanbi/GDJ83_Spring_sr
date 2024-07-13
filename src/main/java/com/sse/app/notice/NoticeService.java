package com.sse.app.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sse.app.util.Pager;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;

	public int add(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.add(noticeDTO);
	}

	public Map<String, Object> getList(Long page,String kind, String search) throws Exception {

		if (page == null) {
			page = 1L;
		}

		if (kind==null) {
			kind="k1";
		}
		
		if(search==null) {
			search="";
		}
		
//		내가 기본적으로 한 화면에 보여주고 싶은 행의 갯수 10개
		Long perPage = 10L;
		

//		보여줄 db의 시작행, 마지막행 구하기
		Long startRow = 1 + (perPage * (page - 1));
		Long lastRow = page * perPage;
		
		Pager pager = new Pager();
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		pager.setKind(kind);
		pager.setSearch(search);
		
		List<NoticeDTO> ar = noticeDAO.getList(pager);

//		내가 보여줘야하는 총 행의 갯수
		Long totalCount = noticeDAO.countList(pager);

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
		
//		내가 있는 현재 블럭 위치
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
		map.put("pre", pre);
		map.put("next", nex);
		map.put("list", ar);
		map.put("kind", kind);
		map.put("search", search);
		
		return map;

	}
	
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		int num = noticeDAO.hit(noticeDTO);
		return noticeDAO.getDetail(noticeDTO);
	}
	
	public int update(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.update(noticeDTO);
	}
	
	public int delete(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.delete(noticeDTO);
	}
}
