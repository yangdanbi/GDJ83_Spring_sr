package com.sse.app.notice;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.sse.app.notice.NoticeDAO.";

	public int add(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", noticeDTO);
	}

	public void getCount() throws Exception {

	}

	public Long countList() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "countList");
	}

}
