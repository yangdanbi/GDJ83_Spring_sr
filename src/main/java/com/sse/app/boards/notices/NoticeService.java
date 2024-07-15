package com.sse.app.boards.notices;

import java.util.List;

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

	public List<NoticeDTO> getList(Pager pager) throws Exception {

		pager.makeRow();
		Long totalCount = noticeDAO.countList(pager);

		pager.makeNum(totalCount);

		return noticeDAO.getList(pager);

	}

	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		int num = noticeDAO.hit(noticeDTO);
		return noticeDAO.getDetail(noticeDTO);
	}

	public int update(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.update(noticeDTO);
	}

	public int delete(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.delete(noticeDTO);
	}
}
