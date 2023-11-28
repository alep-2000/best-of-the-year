package org.java.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

	@GetMapping("/")
	public String test1(Model model) {
		final String name = "Alessio";
		
		model.addAttribute("name", name);
		
		return "Test1";
	}
}
