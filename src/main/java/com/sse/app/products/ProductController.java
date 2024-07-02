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
	public void getDetail(Model model, ProductDTO productDTO) throws Exception {

		System.out.println("detail");

		productDTO = productService.getDetail(productDTO);
		model.addAttribute("dto", productDTO);

	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void addInfo() {
		System.out.println("add페이지 도착");

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addInfo2(Model model, ProductDTO productDTO) throws Exception {
		System.out.println("제출");

		int num = productService.addInfo(productDTO);
		String url = "";

		if (num > 0) {

			url = "redirect:./list";

		}

		return url;
	}

}
