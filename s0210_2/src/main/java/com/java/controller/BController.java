package com.java.controller;

import java.util.Map;

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
	public String blist(@RequestParam(value="page", defaultValue = "1") // page값이 없을땐 page=1이 기본값이 되게(오류방지) 
						int page,Model model, String category, String searchW) {
		System.out.println("BController searchW : "+searchW);
		System.out.println("BController category : "+category);
		Map<String, Object> map = bService.blist(page,category,searchW);
		model.addAttribute("blist",map.get("blist"));
		model.addAttribute("page",map.get("page"));
		model.addAttribute("maxpage",map.get("maxpage"));
		model.addAttribute("startpage",map.get("startpage"));
		model.addAttribute("endpage",map.get("endpage"));
		model.addAttribute("searchW",map.get("searchW"));
		model.addAttribute("category",map.get("category"));
		
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
	public String bview(@RequestParam(defaultValue = "1") int bno,int page,Model model) { // 파라미터 기본값 1로 (타입이 String이 아닐경우)
		// 1개 게시글
		Map<String, Object> map = bService.bview(bno);
		model.addAttribute("boardDto",map.get("boardDto"));
		model.addAttribute("prevDto",map.get("prevDto"));
		model.addAttribute("nextDto",map.get("nextDto"));
		model.addAttribute("page",page);
		return "bview";
	}
	
	@GetMapping("/board/bdelete")
	public String bdelete(int bno,Model model) {

		bService.bdelete(bno);
		return "redirect:/board/blist";
	}
	
	@GetMapping("/board/bupdate")
	public String bupdate(int bno,int page, Model model) {
		BoardDto boardDto = bService.bupdate(bno);
		model.addAttribute("bupdate",boardDto);
		model.addAttribute("page",page);
		return "bupdate";
	}
	
	@PostMapping("/board/bupdate")
	public String bupdate(BoardDto bdto) {
		bService.bupdate(bdto);
		return "redirect:/board/blist";
	}
	
	@GetMapping("/board/breply")
	public String breply(int bno,Model model) {
		BoardDto boardDto = bService.breply(bno);
		model.addAttribute("breply",boardDto);
		return "breply";
	}
	
	@PostMapping("/board/breply")
	public String breply(BoardDto bdto) {
		bService.breply(bdto);
		return "redirect:/board/blist";
	}
	
}
