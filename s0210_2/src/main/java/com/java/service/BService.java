package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BService {

	ArrayList<BoardDto> blist(); // 게시판

	void bwrite(BoardDto dbto); // 글쓰기 저장

	BoardDto bview(int bno); // 게시글 1개 가져오기

	void bdelete(int bno); // 게시글 삭제

}
