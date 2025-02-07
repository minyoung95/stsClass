package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller // url주소를 전부 controller쪽으로 보내줌
public class FController {

	@Autowired
	HttpSession session;
	
	@GetMapping("/")
	public String index() {
		System.out.println("index페이지");
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("login페이지");
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		System.out.println("login post방식");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		session.setAttribute("session_id", id);
		
		return "logInfo";
	}
	
	@RequestMapping("/logout") // GetMapping, PostMapping 2개 모두 사용
	public String logout() {
		session.invalidate();
		return "logout";
	}
	
	@GetMapping("/member")
	public String member() {
		System.out.println("member페이지");
		return "member";
	}
	
	@PostMapping("/member")
	public ModelAndView member(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		String hobby = "";
		for(int i=0;i<hobbys.length;i++) {
			if(i==0) hobby += hobbys[i];
			else hobby += ","+hobbys[i];
		}
		// model 사용 : 매개변수에 Model model 추가
//		model.addAttribute("id",id);
//		model.addAttribute("member",new MemberDto(id, pw, name, tel, gender, hobby));
//		return "memInfo"; // 타입 String
		
		// ModelAndView 사용
		ModelAndView mv = new ModelAndView();
		mv.setViewName("memInfo");
		mv.addObject("member",new MemberDto(id, pw, name, tel, gender, hobby));
		
		return mv; // 메소드 타입을 ModelAndView로 바꾸기
		
	}
	
	@GetMapping("/memInfo")
	public String memInfo() {
		return "memInfo";
	}
	
}
