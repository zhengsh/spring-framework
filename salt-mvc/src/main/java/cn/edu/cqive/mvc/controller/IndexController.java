package cn.edu.cqive.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping("/")
	public ModelAndView index(ModelMap modelMap){
		modelMap.addAttribute("msg","Spring Mvc");
		return new ModelAndView("index");
	}

	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "Hello World!";
	}
}
