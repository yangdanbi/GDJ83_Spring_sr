package com.sse.app.products;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.sse.app.members.MemberDTO;
import com.sse.app.util.Pager;
import com.sse.app.util.ProductCommentPager;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model, Pager pager) throws Exception {

		List<ProductDTO> list = productService.getList(pager);

		model.addAttribute("pager", pager);
		model.addAttribute("list", list);

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
	public String addInfo2(Model model, ProductDTO productDTO, MultipartFile[] attach, HttpSession session)
			throws Exception {
		System.out.println("제출");

		int num = productService.addInfo(productDTO, attach, session);
		String url = "";

		if (num > 0) {

			url = "redirect:./list";

		}

		return url;
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteInfo(Model model, ProductDTO productDTO) {
		System.out.println("삭제");

		int num = productService.deleteInfo(productDTO);
		String url = "";

		if (num > 0) {
			url = "redirect:./list";
		}

		return url;

	}
	// 예외를 최종적으로 처리

	// 세부적으로 컨트롤 하고싶을때 예외종류를 다르게 해서 메세지 보기
	@ExceptionHandler(NullPointerException.class)
	public void exceptionHandler() {

	}

	@ExceptionHandler(Exception.class)
	public void exceptionHandler2() {

	}

	// Exception 에서도 처리하지 못하면 Throwable에서 처리(Throwable는 최상위)
	@ExceptionHandler(Throwable.class)
	public void exceptionHandler3() {

	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void updateInfo(Model model, ProductDTO productDTO) throws Exception {
		System.out.println("수정");

		productDTO = productService.getDetail(productDTO);
		model.addAttribute("dto", productDTO);

	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateInfo2(@ModelAttribute ProductDTO productDTO, Model model) {

		int num = productService.updateInfo(productDTO);
		String url = "";

		if (num > 0) {
			url = "redirect:/product/list";
		}
		return url;
	}

	@GetMapping("addWish")
	public String addWish(Integer item_id, HttpSession session, Model model) throws Exception {

		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		int result = productService.addWish(item_id, memberDTO.getMember_id());

		model.addAttribute("msg", result);

		return "commons/result";

	}

	@GetMapping("wishList")
	public void wishList(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		List<ProductDTO> ar = productService.wishList(memberDTO);
		model.addAttribute("list", ar);
	}

	@GetMapping("deleteWishList")
	public String deletewishList(Integer[] item_id, Model model, HttpSession session) throws Exception {
		for (Integer id : item_id) {

			System.out.println("id : " + id);
		}

		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		int result = productService.deleteWishList(item_id, memberDTO.getMember_id());
		model.addAttribute("msg", result);

		return "commons/result";

	}

	@PostMapping("commentAdd")
	public String commentAdd(HttpSession session, ProductCommentDTO productCommentDTO, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		System.out.println("getMember_id " + memberDTO.getMember_id());

		productCommentDTO.setBoardWriter(memberDTO.getMember_id());
		int result = productService.commentAdd(productCommentDTO);
		model.addAttribute("msg", result);
		return "commons/result";

		// System.out.println("contents : " + contents);

	}

	@GetMapping("commentList")
	public void commentList(ProductCommentPager productCommentPager, Model model) throws Exception {
		List<ProductCommentDTO> list = productService.commentList(productCommentPager);
		model.addAttribute("list", list);
		model.addAttribute("pager", productCommentPager);
	}

	@PostMapping("commentDelete")
	public String commentDelete(ProductCommentDTO productCommentDTO, Model model) throws Exception {
		int result = productService.commentDelete(productCommentDTO);

		model.addAttribute("msg", result);

		return "commons/result";

	}

	@PostMapping("commentUpdate")
	public String commentUpdate(ProductCommentDTO productCommentDTO, Model model,
			ProductCommentPager productCommentPager) throws Exception {
		int result = productService.commentUpdate(productCommentDTO);
		model.addAttribute("msg", result);
		return "commons/result";

		// model.addAttribute("pager", productCommentPager);

	}

}
