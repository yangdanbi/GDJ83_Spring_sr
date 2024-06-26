package com.sse.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/department/*")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		System.out.println("department list");
		List<DepartmentDTO> ar = departmentService.getList();

//		*jsp까지 값을 가져가는 방법
//		1.ModelAndView 객체를 만들기
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("list", ar);
//		
//		return mv;(리턴타입도 ModelAndView)

//		2.Model을 매개변수로 받기 (얘는 리턴 따로 안해도 됨)
		model.addAttribute("list", ar);

	}

	@RequestMapping("detail")
	public String getDetail(Model model, int department_id) throws Exception {
		System.out.println("department detail page");

		DepartmentDTO departmentDTO = departmentService.getDetail(department_id);

		String path = "commons/message";

		if (departmentDTO != null) {
			model.addAttribute("dto", departmentDTO);
			path = "department/detail";
			return path;

		} else {

			model.addAttribute("result", "부서를 찾을 수 없습니다");
			model.addAttribute("url", "./list");
			return path;
		}
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(DepartmentDTO departmentDTO, Model model) throws Exception {

		int result = departmentService.add(departmentDTO);
		String url = "";

		if (result > 0) {
			url = "redirect:./list";

		} else {
			url = "commons/message";
			model.addAttribute("result", "부서 등록에 실패했습니다");
			model.addAttribute("url", "./list");
		}
		return url;

	}

	@RequestMapping("delete")
	public String delete(DepartmentDTO departmentDTO, Model model) throws Exception {
		System.out.println("delete page");

		int result = departmentService.delete(departmentDTO);
		String url = "";

		if (result > 0) {
			url = "redirect:./list";
		} else {
			url = "commons/message";
			model.addAttribute("result", "부서 삭제에 실패했습니다");
			model.addAttribute("url", "./list");
		}

		return url;
	}

	@RequestMapping("update")
	public String update(int department_id, Model model) throws Exception {
		DepartmentDTO departmentDTO = departmentService.getDetail(department_id);
		String url = "";

		if (departmentDTO != null) {

			url = "department/update";
			model.addAttribute("dto", departmentDTO);

		} else {
			url = "commons/message";
			model.addAttribute("result", "없는 부서입니다");
			model.addAttribute("url", "./list");
		}

		return url;

	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(DepartmentDTO departmentDTO) throws Exception {

		int result = departmentService.update(departmentDTO);

		return "redirect:list";

	}

}
