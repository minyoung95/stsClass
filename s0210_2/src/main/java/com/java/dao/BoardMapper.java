package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	ArrayList<BoardDto> blist();

	int bwrite(BoardDto dbto);

	BoardDto bview(int bno);

	// 조회수 1증가
	void updateBhit(int bno);

	// 게시글 삭제
	void bdelete(int bno);

	
}
