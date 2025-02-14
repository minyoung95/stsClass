package com.java.customerController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.BoardDto;
import com.java.service.CService;

@Controller
public class CController {
	
	@Autowired CService cService;
	
	@GetMapping("customer/notice")
	public String notice(@RequestParam(value="page", defaultValue = "1") int page, Model model) {
		
		// 현재 날짜
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(d);
		System.out.println("현재날짜 : "+today);
		
		Map<String, Object> list = cService.notice(page);
		
		model.addAttribute("list",list.get("list"));
		model.addAttribute("page",list.get("page"));
		model.addAttribute("maxpage",list.get("maxpage"));
		model.addAttribute("startpage",list.get("startpage"));
		model.addAttribute("endpage",list.get("endpage"));
		model.addAttribute("today",today);
		return "customer/notice";
	}
	
	@GetMapping("customer/nview")
	public String nview(int bno,Model model) {
		
		BoardDto boardDto = cService.nview(bno);
		model.addAttribute("bdto",boardDto);
		
		return "customer/nview";
	}
	
}
