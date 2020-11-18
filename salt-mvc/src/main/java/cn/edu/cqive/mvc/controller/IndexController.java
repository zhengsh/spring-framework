package cn.edu.cqive.mvc.controller;

import cn.edu.cqive.mvc.annotation.Controller;
import cn.edu.cqive.mvc.annotation.RequestMapping;
import cn.edu.cqive.mvc.annotation.ResponseBody;
import cn.edu.cqvie.ioc.annotation.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * spring mvc 测试控制器
 *
 * @author zhengsh
 * @date 2020-11-17
 */
@Component
@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		if (new Object() instanceof Object) {

		}
		request.setAttribute("msg", "Spring Mvc");
		return "index";
	}

	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "Hello World!";
	}
}
