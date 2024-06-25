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

}
