package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.dto.MemDto;
import com.java.service.MService;

@Controller
public class FController {

	@Autowired MService mService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/member/mlist")
	public String mlist(Model model) {
		
		ArrayList<MemDto> list = mService.mlist();
		model.addAttribute("list",list);
		return "member/mlist";
	}
}
