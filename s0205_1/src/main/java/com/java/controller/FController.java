package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("get방식");
		return "login";
	}
	
	@PostMapping("/doLoign")
	public String doLogin(HttpServletRequest request) {
		
		System.out.println("post방식");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		session.setAttribute("session_id", id);
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout() {
		
		session.invalidate();
		return "logout";
	}
}
