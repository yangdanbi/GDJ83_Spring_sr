package com.sse.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		System.out.println("list");

		List<ProductDTO> ar = productService.getList();

		model.addAttribute("list", ar);

	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void getDetail(Model model, int item_id) throws Exception {

		System.out.println("detail");

		ProductDTO productDTO = productService.getDetail(item_id);
		model.addAttribute("dto", productDTO);

	}

}
