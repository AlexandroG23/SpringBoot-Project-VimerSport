package com.aasencios.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {

	@RequestMapping("vimersport")
	public String vimer() {
		return "index";
	}
	
	@RequestMapping("/registro")
	public String formulario() {
		return "formulario";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
}
