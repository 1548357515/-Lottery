package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class PageController {
	/*
	 * 打开首页
	 * 直接访问根路径就跳转到index.jsp
	 */
	@RequestMapping("/")
	public String showIndex() {
		System.out.println("进入");
		return "admin";
	}
	
	
}
