package com.sse.app.products;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	public List<ProductDTO> getList(Long page) throws Exception {

		if (page == null) {
			page = 1L;
		}
		long perPage = 10;
		long startRow = 1 + (perPage * (page - 1));
		long lastRow = page * perPage;

		List<Long> ar = new ArrayList<Long>();

		ar.add(startRow);
		ar.add(lastRow);

		long totalCount = productDAO.getTotalCount();
		long totalPage = totalCount / perPage;

		if (totalCount % perPage != 0) {
			totalPage = totalCount / perPage + 1;
		} else {
			totalPage = totalCount / perPage;
		}

		System.out.println(totalPage);
		return productDAO.getList(ar);

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
