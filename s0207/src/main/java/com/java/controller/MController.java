package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MController {
	
	@Autowired
	HttpSession session; // 세션 객체

	@GetMapping("/login")
	public String login() {
		return "member/login";
	} // get login
	
	@PostMapping("/login")
	public String login(String id, String pw, Model model) {
		
		// db접근하여 id,pw가 맞는지 확인
		if(id.equals("aaa") && pw.equals("1111")) {
//			model.addAttribute("chk","1"); // redirect로 값을 넘겨줄때 model은 넘어가지않음
//			session.removeAttribute("logoutChk"); // 세션 1개 삭제
			session.setAttribute("session_id", id); // 세션 저장
			return "redirect:/?chk=1"; // redirect:x - x페이지로, ?chk=1 :파라미터 값으로 chk=1을 보내줌
			
		}else {
			return "redirect:/member/login?chk=0";
		}
		
	} // post login
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate(); // 세션 모두삭제
		return "redirect:/?logoutChk=1";
	} // get logout
	
} // MController
