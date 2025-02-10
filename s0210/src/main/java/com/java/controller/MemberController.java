package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.Member;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	// MemberService memberService = new MemberServiceImpl();
	@Autowired HttpSession session;
	
	@GetMapping("/member/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/member/login")
	public String login(String id, String pw, Model model) {
		
		Member memberDto = memberService.login(id,pw);
		if(memberDto != null) { // 로그인 성공시
			model.addAttribute("chkLogin","1");
			session.setAttribute("session_id", id);
			session.setAttribute("session_name", memberDto.getName());
		}else {
			model.addAttribute("chkLogin","0"); // 로그인 실패시			
		}
		return "login";
	}
	
	@GetMapping("/member/logout")
	public String logout(Model model) {
		session.invalidate();
		model.addAttribute("chkLogin", "0");
		return "logout";
	}
	
	@GetMapping("/member/member")
	public String member() {
		return "member";
	}
	
	@PostMapping("/member/member")
	public String member(Member mdto) {
		memberService.member(mdto);
		
		return "redirect:/";
	}
}
