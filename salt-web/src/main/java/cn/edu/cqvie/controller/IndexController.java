package cn.edu.cqvie.controller;

import cn.edu.cqvie.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * spring mvc 测试控制器
 *
 * @author zhengsh
 * @date 2020-11-17
 */
@Controller
public class IndexController {

	@Autowired
	private GoodsService goodsService;

	@RequestMapping("/index")
	public String index(@RequestParam("name") String name, HttpServletRequest request) {
		request.setAttribute("name", name);
		goodsService.test();

		return "index";
	}

	@RequestMapping("/test")
	@ResponseBody
	public Map<String, String> test(@RequestParam("name") String name, HttpServletRequest request) {
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		return map;
	}
}
