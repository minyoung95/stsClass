package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.service.BService;

@Controller
public class FController {
	
	@Autowired BService bService;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@ResponseBody // 데이터요청
	@GetMapping("/rpage")
	public String rpage() {
		return "rpage";
	}
	
	
	@GetMapping("/board/bwrite")
	public String bwrite() {
		return "bwrite";
	}
	
	@PostMapping("/board/bwrite") // 파일 1개 업로드
	public String bwrite(BoardDto bdto,@RequestPart MultipartFile files) throws Exception {
		
		String realName = "";
		
		// 파일 첨부가 되어있을 경우
		if(!files.isEmpty()) {
			// 중복방지를 위한 파일이름(시간추가 or 랜덤문자추가) 변경
			String originName = files.getOriginalFilename(); // 최초파일이름
			long time = System.currentTimeMillis(); // 시간정하기
//			UUID uuid = UUID.randomUUID(); // 랜덤문자생성
//			String uName = uuid+"_"+originName;
			realName = String.format("%d_%s", time, originName);
			
			// 파일저장위치 ( / = \\)
			String url="C:/upload/board/";
//			String url="C:/worksts/s0212/src/main/resources/static/upload/";
			
			// 파일저장
			File f = new File(url+realName);
			
			// 파일업로드
			files.transferTo(f);
			
			// 파일명 인코딩 처리
	        realName = URLEncoder.encode(realName, StandardCharsets.UTF_8);
	        
			// dto에 저장
			bdto.setBfile(realName);
			} else {
			bdto.setBfile("");
		} // isEmpty()
		
		// 게시글저장
		bService.bwrite(bdto);
			
		System.out.println("파일업로드 성공");
		
		return "redirect:/board/blist";
	}
	
//	@PostMapping("/board/bwrite") // 파일 여러개 업로드
//	public String bwrite(BoardDto bdto,List<MultipartFile> files) throws Exception {
//		
//		String realName = "";
//		
//		// 파일 첨부가 되어있을 경우
//		if(!files.isEmpty()) {
//			
//			for(MultipartFile file : files) {
//				
//				// 중복방지를 위한 파일이름(시간추가 or 랜덤문자추가) 변경
//				String originName = file.getOriginalFilename(); // 최초파일이름
//				long time = System.currentTimeMillis(); // 시간정하기
//				UUID uuid = UUID.randomUUID(); // 랜덤문자생성
//				String uName = uuid+"_"+originName;
//				realName = String.format("%d_%s", time, originName);
//				
//				// 파일저장위치 ( / = \\)
//				String url="C:/upload/board/";
//				String url="C:/worksts/s0212/src/main/resources/static/upload/";
//				
//				// 파일저장
//				File f = new File(url+realName);
//				
//				// 파일업로드
//				file.transferTo(f);
//				
//				// 파일명 인코딩 처리
//				realName = URLEncoder.encode(realName, StandardCharsets.UTF_8);
//				
//				
//			}
//			// dto에 저장
//			bdto.setBfile(realName);
//			} else {
//			bdto.setBfile("");
//		} // isEmpty()
//		
//		// 게시글저장
//		bService.bwrite(bdto);
//			
//		System.out.println("파일업로드 성공");
//		
//		return "redirect:/board/blist";
//	}
	
	@GetMapping("/board/blist")
	public String blist(Model model) {
		ArrayList<BoardDto> list = bService.blist();
		model.addAttribute("list",list);
		return "blist";
	}
	
	@GetMapping("/board/bview")
	public String bview(int bno, Model model) {
		BoardDto boardDto = bService.bview(bno);
		model.addAttribute("bdto",boardDto);
		return "bview";
	}
}
