package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.CboardDto;
import com.java.service.EService;

import jakarta.servlet.http.HttpSession;

@RestController // 데이터 넘기기
public class ReController {

	@Autowired HttpSession session;
	@Autowired EService eService;
	
//	@ResponseBody : @RestController로 인해 생략가능
	@PostMapping("/event/cwrite")
	public CboardDto cwrite(CboardDto cdto) {
		System.out.println("eno : "+cdto.getEno());
		System.out.println("cpw : "+cdto.getCpw());
		System.out.println("ccontent : "+cdto.getCcontent());
		
		cdto.setId((String) session.getAttribute("session_id"));
		
		CboardDto cboardDto = eService.cwrite(cdto);
		return cboardDto;
	} // 데이터 전달, 페이지오픈 x
	
	@PostMapping("/event/cdelete")
	public String cdelete(int cno) {
		System.out.println("cno : "+cno);
		
		eService.cdelete(cno);
		return "1";
	} // 데이터 전달, 페이지오픈 x
	
	@PostMapping("/event/cupdate")
	public CboardDto cupdate(CboardDto cdto) {
		System.out.println("eno : "+cdto.getEno());
		System.out.println("cno : "+cdto.getCno());
		System.out.println("ccontent : "+cdto.getCcontent());
		
		cdto.setId((String) session.getAttribute("session_id"));
		
		CboardDto cboardDto = eService.cupdate(cdto);
		return cboardDto;
	} // 데이터 전달, 페이지오픈 x
}
