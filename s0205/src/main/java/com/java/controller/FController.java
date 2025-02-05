package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller 
// 객체를 생성하여 메모리로 
// jsp호출시(url링크) 전부 Controller로 들어옴 후에 분기
public class FController {
	
	@Autowired // 객체선언 생략가능
	HttpSession session;
	
	@GetMapping("/")
	public String index() {
		return "index"; // .jsp는 생략
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("get방식");
		return "login"; // .jsp는 생략
	}
	
	@PostMapping("/doLogin")
	public String doLogin(HttpServletRequest request) {
		System.out.println("post방식");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
//		HttpSession session = request.getSession();
		session.setAttribute("session_id", id); // 세션추가
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout() {
		
		session.invalidate(); // 세션 전부삭제
		return "logout"; // .jsp는 생략
	}
}
