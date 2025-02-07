package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.dto.BoardDto;
import com.java.dto.MemberDto;
import com.java.service.BService;
import com.java.service.MService;

@Controller
public class FController {

	@Autowired BService bService;
	MService mService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/board/blist")
	public String blist(Model model) {
		
		ArrayList<BoardDto> list = bService.blist();
		
		model.addAttribute("list",list);
		return "blist";
	}
	
	@GetMapping("/member/memInfo")
	public String mlist(Model model) {
		
		ArrayList<MemberDto> list = mService.mlist(); 
		
		model.addAttribute("list",list);
		return "mlist";
	}
}
