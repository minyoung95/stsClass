package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.BoardDto;
import com.java.service.BService;

@Controller
public class BController {

	@Autowired BService bService;
	
	@GetMapping("/board/blist")
	public String blist(Model model) {
		
		ArrayList<BoardDto> list = bService.blist();
		model.addAttribute("list",list);
		return "blist";
	}
	
	@GetMapping("/board/bwrite")
	public String bwrite() {
		return "bwrite";
	}
	
	@PostMapping("/board/bwrite")
	public String bwrite(BoardDto dbto,Model model) {
		bService.bwrite(dbto);
		return "redirect:/board/blist?chkBwrite=1";
	}
	
	@GetMapping("/board/bview")
	public String bview(@RequestParam(defaultValue = "1") int bno,Model model) { // 파라미터 기본값 1로 (타입이 String이 아닐경우)
		// 1개 게시글
		BoardDto boardDto = bService.bview(bno);
		model.addAttribute(boardDto);
		return "bview";
	}
	
	@GetMapping("/board/bdelete")
	public String bdelete(int bno,Model model) {

		bService.bdelete(bno);
		return "redirect:/board/blist";
	}
	
}
