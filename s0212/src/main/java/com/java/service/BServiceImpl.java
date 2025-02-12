package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Service
public class BServiceImpl implements BService{

	@Autowired BoardMapper boardMapper;
	
	@Override // 전체리스트
	public ArrayList<BoardDto> blist() {
		
		ArrayList<BoardDto> list = boardMapper.selectAll();
		return list;
	}

	@Override
	public void bwrite(BoardDto bdto) {
		boardMapper.insertBoard(bdto);
	}

	@Override
	public BoardDto bview(int bno) {

		BoardDto boardDto = boardMapper.selectOne(bno);
		return boardDto;
	}

	
}
