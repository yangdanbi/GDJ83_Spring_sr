package com.sse.app.products;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sse.app.DefaultTest;

public class ProductDAOTest extends DefaultTest {

	@Autowired
	private ProductDAO productDAO;

	public void getDetailTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setItem_id(99);
		productDTO = productDAO.getDeatil(productDTO);

//		단정문
		assertNotNull(productDTO);
	}

	@Test
	public void addInfoTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setItem_name("비가");
		productDTO.setItem_detail("와요");
		productDTO.setItem_rate(7.08);
		int result = productDAO.addInfo(productDTO);

		assertEquals(1, result);

	}

	public void accountInfoTest() throws Exception {

	}

}
