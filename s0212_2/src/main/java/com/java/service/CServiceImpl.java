package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.CMapper;
import com.java.dto.BoardDto;

@Service
public class CServiceImpl implements CService{

	@Autowired CMapper cMapper;
	int rowPerPage = 10; // 한 페이지당 게시글 수
	
	@Override
	public Map<String, Object> notice(int page) {
		
		// 게시글 총 갯수
		int count = cMapper.countAll();
		
		// 페이지 넘버링
		int maxpage = (int)Math.ceil((double)count/rowPerPage);
		// 1~10페이지 1그룹, 11~20페이지 2그룹 : 아래 페이지넘버링이 1~10페이지에서는 1~10 넘버링이 나타나게
		int startpage = (int)((page-1)/10)*10+1; 
		// 1그룹일땐 10페이지가 끝, 2그룹일땐 20페이지가 끝
		int endpage = startpage+10-1;
		if(endpage>maxpage) endpage=maxpage;
		
		// 게시글?
		int startrow = (page-1)*10+1; // 1페이지일때 1번게시글
		int endrow = startrow + rowPerPage - 1; // 1번 게시글일때 10번게시글까지
		
		ArrayList<BoardDto> list = cMapper.selectAll(startrow,endrow);
		
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		map.put("maxpage", maxpage);
		map.put("startpage", startpage);
		map.put("endpage", endpage);
		map.put("list", list);
		return map;
	}

	@Override
	public BoardDto nview(int bno) {
		
		BoardDto boardDto = cMapper.selectOne(bno);
		return boardDto;
	}

}
