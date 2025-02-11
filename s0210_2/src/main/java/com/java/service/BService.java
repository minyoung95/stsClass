package com.java.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.dto.BoardDto;

public interface BService {

	Map<String, Object> blist(int page, String category, String searchW); // 게시판

	void bwrite(BoardDto dbto); // 글쓰기 저장

	Map<String, Object> bview(int bno); // 게시글 1개 가져오기

	void bdelete(int bno); // 게시글 삭제

	BoardDto bupdate(int bno); // 게시글 수정

	void bupdate(BoardDto bdto); // 게시글 수정 저장

	BoardDto breply(int bno); // 답변달기

	void breply(BoardDto bdto);

}
