package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.dto.BoardDto;
import com.java.service.BService;
import com.java.service.BServiceImpl;

@Controller
public class BController {

//	BService bService = new BServiceImpl();
	@Autowired BService bService;
	
	@GetMapping("/board/blist") // url
	public String board(Model model) {
		
		// 게시글 여러개 가져오기 : ArrayList
		// 게시글 1개 가져오기 : BoardDto
		ArrayList<BoardDto> list = bService.blist();
		
		//jsp 페이지에 보내기 : model
		model.addAttribute("list",list);
		
		return "board/blist"; // 폴더위치
	}
}
