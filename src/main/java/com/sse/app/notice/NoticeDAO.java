package com.sse.app.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sse.app.util.Pager;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.sse.app.notice.NoticeDAO.";

	public int add(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", noticeDTO);
	}

	public Long countList(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "countList", pager);
	}

	public List<NoticeDTO> getList(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", noticeDTO);
	}
	
	public int hit(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"hit", noticeDTO);
	}
	
	public int update (NoticeDTO noticeDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"update",noticeDTO);
	}
	
	public int delete (NoticeDTO noticeDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"delete", noticeDTO);
	}
	
}
