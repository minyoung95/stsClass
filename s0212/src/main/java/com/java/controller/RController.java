package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.BoardDto;
import com.java.service.BService;

@RestController // 데이터 요청
public class RController {
	
	@Autowired BService bService;

	@GetMapping("/restpage")
	public ArrayList<BoardDto> restpage() {
		ArrayList<BoardDto> list = bService.blist();
		// react에서 /restpage 호출
		return list; // 리턴값이 넘어감
	}
}
