package com.sse.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	public List<ProductDTO> getList() throws Exception {

		return productDAO.getList();

	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {

		return productDAO.getDeatil(productDTO);

	}

	public int addInfo(ProductDTO productDTO) throws Exception {

		return productDAO.addInfo(productDTO);

	}

}
