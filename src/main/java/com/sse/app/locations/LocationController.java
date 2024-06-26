package com.sse.app.locations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sse.app.departments.DepartmentDTO;

@Controller
@RequestMapping("/location/*")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@RequestMapping("list")
	public void getList(Model model) throws Exception {
		System.out.println("location list");
		List<LocationDTO> ar = locationService.getList();
		model.addAttribute("list", ar);

	}

	@RequestMapping("detail")
	public void getDetail(Model model, int location_id) throws Exception {
		System.out.println("location detail page");

		LocationDTO locationDTO = locationService.getDetail(location_id);
		model.addAttribute("dto", locationDTO);

	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(LocationDTO locationDTO, Model model) throws Exception {

		int num = locationService.add(locationDTO);
		String path = "redirect:list";

		if (num > 0) {
			path = "redirect:list";
		} else {
			path = "commons/message";
			model.addAttribute("result", "지역 추가에 실패했습니다");
			model.addAttribute("url", "./list");
		}

		return path;
	}

	@RequestMapping("delete")
	public String delete(LocationDTO locationDTO, Model model) throws Exception {
		System.out.println("delete page");

		int result = locationService.delete(locationDTO);
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
	public String update(int location_id, Model model) throws Exception {
		LocationDTO locationDTO = locationService.getDetail(location_id);
		String url = "";

		if (locationDTO != null) {

			url = "location/update";
			model.addAttribute("dto", locationDTO);

		} else {
			url = "commons/message";
			model.addAttribute("result", "없는 지역입니다");
			model.addAttribute("url", "./list");
		}

		return url;

	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(LocationDTO locationDTO) throws Exception {

		int result = locationService.update(locationDTO);

		return "redirect:list";

	}
	
}
