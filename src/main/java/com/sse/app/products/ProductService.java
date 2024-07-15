package com.sse.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sse.app.util.Pager;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	public List<ProductDTO> getList(Pager pager) throws Exception {

		pager.makeRow();
		Long totalCount = productDAO.getTotalCount(pager);

		pager.makeNum(totalCount);

		return productDAO.getList(pager);

	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {

		return productDAO.getDeatil(productDTO);

	}

	public int addInfo(ProductDTO productDTO) throws Exception {

		return productDAO.addInfo(productDTO);

	}

	public int deleteInfo(ProductDTO productDTO) {
		return productDAO.deleteInfo(productDTO);
	}

	public int updateInfo(ProductDTO productDTO) {

		return productDAO.updateInfo(productDTO);

	}

}
