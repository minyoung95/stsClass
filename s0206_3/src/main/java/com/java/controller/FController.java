package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.StuDto;
import com.java.dto.StuScore;
import com.java.service.BService;
import com.java.service.BServiceImpl;
import com.java.service.BServiceImpl2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class FController {

	@Autowired 
	HttpSession session;
	BService b; // 인터페이스명 넣기
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	@PostMapping("/member")
	public String member(StuDto StuDto, Model model) {
		System.out.println("hobby : "+StuDto.getHobby());
		model.addAttribute("mem",StuDto);
		return "memInfo";
	}
	
	// 매개변수로 전달받음
//	@PostMapping("/member")
//	public String member(HttpServletRequest request, @RequestParam String id,
//			String pw, String name, String tel, String gender, String hobbys, String[] hobby, Model model) {
//		
//		hobbys = "";
//		for(int i=0;i<hobby.length;i++) {
//			if(i==0) hobbys += hobby[i];
//			else hobbys += ","+hobby[i];
//		}
//		model.addAttribute("mem",StuDto.builder().id(id).pw(pw).name(name).tel(tel).gender(gender).hobbys(hobbys).build());
//		
//		return "memInfo";
//	}
	
	@GetMapping("/stuInput")
	public String stuInput() {
		return "stuInput";
	}
	
	@PostMapping("/stuInput")
	public String stuInput(StuScore StuScore, Model model) {
		
		int total = StuScore.getKor()+StuScore.getEng()+StuScore.getMath();
		double avg = total/3.0;
		
		model.addAttribute("Score",StuScore);
		model.addAttribute("total",total);
		model.addAttribute("avg",avg);
		
		return "doStuInput";
	}
		
	@GetMapping("/data")
	public String data(@RequestParam(defaultValue = "1")int bno,
			Model model) {
		System.out.println("bno: "+bno);
		model.addAttribute("bno",bno);
		return "data";
	}
	
	@GetMapping("/data2/{bno}") //pathvariable 방식
	public String data2(@PathVariable int bno,
			Model model) {
		System.out.println("bno: "+bno);
		model.addAttribute("bno",bno);
		return "data2";
	}
	@GetMapping("/data3/{bno}") //pathvariable 방식
	public String data3(@PathVariable List<Integer> bno,
			Model model) {
		System.out.println("bno: "+bno);
		model.addAttribute("bno",bno);
		return "data3";
	}
	
	@GetMapping("/data4")
	public String data4() {
		
		String str = b.slist();
		System.out.println(str);
		return "data4";
	}
}
