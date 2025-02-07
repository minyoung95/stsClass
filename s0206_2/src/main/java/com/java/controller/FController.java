package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.MemDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
	@Autowired HttpSession session;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request,			
			@RequestParam("id") String id, // form name = "id" 데이터 입력받음
			@RequestParam(required = false) String pw, // null값 허용
			String name, // @RequestParam 생략가능, form의 name = ""과 같아야함
			@RequestParam int kor,
			@RequestParam(defaultValue = "0") int eng, // 값이 없을 때 0으로 처리
			int math, Model model) {
		
//		String aid = request.getParameter("id");
//		String apw = request.getParameter("pw");
//		String akor = request.getParameter("kor");
//		String aeng = request.getParameter("eng");
//		String amath = request.getParameter("math");
//		int total = Integer.parseInt(akor) + Integer.parseInt(aeng)+Integer.parseInt(amath);
//		double avg = total/3.0;
		
		int total = kor+eng+math;
		double avg = total/3.0;
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		model.addAttribute("kor",kor);
		model.addAttribute("eng",eng);
		model.addAttribute("math",math);
		model.addAttribute("total",total);
		model.addAttribute("avg",avg);
		model.addAttribute("member",MemDto.builder().id(id).pw(pw).build());
		
		return "dologin";
	}
	
	@GetMapping("/stuInput")
	public String stuInput() {
		return "stuInput";
	}
	
	@PostMapping("/stuInput")
	public String stuInput(HttpServletRequest request,
			@RequestParam int stuno, int kor, int eng, int math,
			String name, Model model) {
		
		int total = kor+eng+math;
		double avg = total/3.0;
		
		model.addAttribute("stuno",stuno);
		model.addAttribute("name",name);
		model.addAttribute("kor",kor);
		model.addAttribute("eng",eng);
		model.addAttribute("math",math);
		model.addAttribute("total",total);
		model.addAttribute("avg",avg);
		
		return "doStuInput";
	}
	
	@GetMapping("/board")
	public String board(int bno, String btitle, Model model) {
		
		model.addAttribute("bno",bno);
		model.addAttribute("btitle",btitle);
		
		return "board";
	}
		
}
