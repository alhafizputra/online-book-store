package com.glints.onlinebookstore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {

	@GetMapping
	public String welcome() {
		return "Welcome to Online Book Store Application";
	}
}
