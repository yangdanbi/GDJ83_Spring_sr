package com.sse.app.products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sse.app.util.Pager;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	public Map<String, Object> getList(Long page, String kind, String search) throws Exception {

		if (page == null) {
			page = 1L;
		}

		if (page < 1) {
			page = 1L;
		}

		if (search == null) {
			search = "";
		}

//		보여줄 db의 시작행, 마지막행 구하기
		long perPage = 10;
		long startRow = 1 + (perPage * (page - 1));
		long lastRow = page * perPage;

		List<Long> ar = new ArrayList<Long>();

		ar.add(startRow);
		ar.add(lastRow);

		Pager pager = new Pager();
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		pager.setKind(kind);
		pager.setSearch(search);

//		1. 총 갯수(PK컬럼의 갯수) 총 페이지수 구하기, 내가 한 페이지에 몇개를 보여줄건지->그럼 몇 페이지가 나오는지
		long totalCount = productDAO.getTotalCount(pager);
		long totalPage = totalCount / perPage;

		if (totalCount % perPage != 0) {
			totalPage = totalCount / perPage + 1;
		} else {
			totalPage = totalCount / perPage;
		}

//		2. 블럭의 수 구하기, 5개짜리 페이지가 몇 묶음이냐, 몇 블럭이냐
//		한번에 보여질 페이지의 갯수
		long perBlock = 5;
//		총 블럭의 수(5개짜리 페이지가 몇 묶음이냐, 몇 블럭이냐)
		long totalBlock = 0;

		if (totalPage % perBlock != 0) {
			totalBlock = totalPage / perBlock + 1;
		} else {
			totalBlock = totalPage / perBlock;
		}

//		3. 현재페이지번호로 현재블럭 번호 구하기

		long curBlock = 0;

		if (page % perBlock != 0) {
			curBlock = page / perBlock + 1;
		} else {
			curBlock = page / perBlock;
		}

//		4. 현재 블럭 번호로 시작번호와 끝번호를 구하기

//		curBlock
		long startNum = 1 + (perBlock * (curBlock - 1));
		long lastNum = curBlock * perBlock;

//		5. 이전블럭, 다음블럭 유무 판단
		boolean pre = true; // true면 이전블럭 존재, false면 이전블럭 존재x
		boolean next = true; // true면 다음블럭 존재, false면 다음블럭 존재x
		if (curBlock == 1) {
			pre = false;
		}

		if (curBlock == totalBlock) {
			next = false;
			lastNum = totalPage;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", productDAO.getList(pager));
		map.put("totalPage", totalPage);
		map.put("startNum", startNum);
		map.put("lastNum", lastNum);
		map.put("pre", pre);
		map.put("next", next);
		map.put("kind", kind);
		map.put("search", search);

		return map;

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
