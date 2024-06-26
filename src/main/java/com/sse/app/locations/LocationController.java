package com.sse.app.locations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		String path = "redirect:./list";

		if (num > 0) {
			path = "location/list";
		} else {
			path = "commons/message";
			model.addAttribute("result", "지역 추가에 실패했습니다");
			model.addAttribute("url", "./list");
		}

		return path;
	}

}
