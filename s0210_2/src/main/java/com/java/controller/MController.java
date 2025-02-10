package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.MemberDto;
import com.java.service.MService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MController {
	
	@Autowired MService mService;
	@Autowired HttpSession session;
	
	@GetMapping("member/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("member/login")
	public String login(MemberDto mdto, Model model) {
		
		MemberDto memberDto = mService.login(mdto);
		if(memberDto != null) {
			model.addAttribute("chkLogin","1");
			session.setAttribute("session_id", mdto.getId());
			session.setAttribute("session_name", mdto.getName());
		}else {
			model.addAttribute("chkLogin","0");
		}
		return "login";
	}
	
	@GetMapping("member/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/?logout=1";
	}
}
