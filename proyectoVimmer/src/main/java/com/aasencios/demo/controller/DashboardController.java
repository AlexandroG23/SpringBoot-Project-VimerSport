package com.aasencios.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

	@RequestMapping("/principal")
	public String dashboard() {
		return "principal";
	}
}
