package com.msb.todoManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/")
public class HomeController {

	@GetMapping(value={"/home", "/"})
	public String home(){
		return "home";
	}
}
