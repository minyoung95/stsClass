package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@RequestMapping("/board")
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	
	@GetMapping("/blist")
	public String blist(Model model) {
		
		ArrayList<BoardDto> list = boardService.blist();
		model.addAttribute("list",list);
		return "board/blist";
	}
	
	@GetMapping("/bview")
	public String bview(int bno) {
		System.out.println(bno);
		// select * from board where bno=2;
//		BoardDto boardDto = boardService.bview(bno); // bno가 일치하는 게시글 하나만 가져오기
		// select * from board where btitle like '%3%' : 제목에 3이 들어간 게시글 찾기
		return "board/bview";
	}
}
