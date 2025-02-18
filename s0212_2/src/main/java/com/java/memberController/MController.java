package com.java.memberController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.MemberDto;
import com.java.service.MService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MController {

	@Autowired HttpSession session;
	@Autowired MService mService;
	
	@GetMapping("/member/login")
	public String login(HttpServletResponse response, HttpServletRequest request) {
		
		// 쿠키생성
//		Cookie cookie = new Cookie("cook_id", "aaa");
//		cookie.setMaxAge(60*60*24); // 60초*60분*24시간
//		response.addCookie(cookie);
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
	
	@GetMapping("/member/step01")
	public String step01() {
		return "member/step01";
	}
	
	@GetMapping("/member/step02")
	public String step02() {
		session.removeAttribute("pwCode"); // 세션삭제
		return "member/step02";
	}
	
	@ResponseBody
	@PostMapping("/member/sendEmail")
	public String sendEmail(String email) {
		
//		String pwCode = mService.sendEmail(email); // text
		String pwCode = mService.sendEmail2(email); // html
		session.setAttribute("pwCode", pwCode);
		return pwCode;
	}
	
	@ResponseBody
	@PostMapping("/member/pwCode")
	public String pwCode(String pwCode) {
		
		String pw = (String)session.getAttribute("pwCode");
		if(pwCode.equals(pw)) {
			return "1";
		}else {
			return "0";
		}
	}
	
}
