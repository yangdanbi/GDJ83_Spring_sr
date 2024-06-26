package com.sse.app.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee/*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("list")
	public String getList(Model model) throws Exception {
		System.out.println("employee list");

		List<EmployeeDTO> ar = employeeService.getList();
		model.addAttribute("list", ar);
		return "employee/list";
	}

}
