package com.java.memberController;

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

	@Autowired HttpSession session;
	@Autowired MService mService;
	
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public String login(MemberDto mdto, Model model) {
		
		MemberDto memberDto = mService.login(mdto);
		if(memberDto!=null) {
			session.setAttribute("session_id", memberDto.getId());
			return "redirect:/?loginChk=1";
		}else {
			model.addAttribute("loginChk",0);
		}
		return "member/login";
	}
	
	@GetMapping("/member/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/?loginChk=0";
	}
}
