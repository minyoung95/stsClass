package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardMapper;
import com.java.dto.Board;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired BoardMapper boardMapper;
	
	@Override
	public ArrayList<Board> blist() {
		
		ArrayList<Board> list = boardMapper.blist();
		return list;
	}

	@Override
	public void bwrite(Board bdto) {
		boardMapper.bwrite(bdto);
	}
	
}
