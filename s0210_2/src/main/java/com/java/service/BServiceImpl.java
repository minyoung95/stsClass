package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Service
public class BServiceImpl implements BService{

	@Autowired BoardMapper boardMapper;
	
	// 게시판리스트
	@Override
	public ArrayList<BoardDto> blist() {
		
		ArrayList<BoardDto> blist = boardMapper.blist();
		return blist;
	}
	
	// 게시글 쓰기
	@Override
	public void bwrite(BoardDto dbto) {
		
		int result = boardMapper.bwrite(dbto);
		
	}
	
	// 게시글 1개 가져오기
	@Override
	public BoardDto bview(int bno) {
		
		// 조회수 1 증가 - update
		boardMapper.updateBhit(bno);
		BoardDto boardDto = boardMapper.bview(bno);
		return boardDto;
	}
	
	// 게시글 삭제
	@Override
	public void bdelete(int bno) {
		
		boardMapper.bdelete(bno);
	}

}
