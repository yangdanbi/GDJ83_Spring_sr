package com.sse.app.products;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sse.app.util.Pager;

@Repository
public class ProductDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.sse.app.products.ProductDAO.";

	public List<ProductDTO> getList(Pager pager) throws Exception {

		return sqlSession.selectList(NAMESPACE + "getList", pager);

	}

	public Long getTotalCount(Pager pager) throws Exception {

		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);

	}

	public ProductDTO getDeatil(ProductDTO productDTO) throws Exception {

		return sqlSession.selectOne(NAMESPACE + "getDetail", productDTO);

	}

	public int addInfo(ProductDTO productDTO) throws Exception {

		return sqlSession.insert(NAMESPACE + "addInfo", productDTO);
	}

	public int deleteInfo(ProductDTO productDTO) {

		return sqlSession.delete(NAMESPACE + "deleteInfo", productDTO);
	}

	public int updateInfo(ProductDTO productDTO) {

		return sqlSession.update(NAMESPACE + "updateInfo", productDTO);

	}

}