package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	ArrayList<BoardDto> blist(int startrow,int endrow, String category, String searchW);
	// 페이지넘버링
	int countAll(String category, String searchW);

	int bwrite(BoardDto dbto);

	BoardDto bview(int bno);

	// 조회수 1증가
	void updateBhit(int bno);

	// 게시글 삭제
	void bdelete(int bno);
	
	// 게시글 수정
	BoardDto bupdateview(int bno);
	
	// 게시글 수정저장
	void bupdate(BoardDto bdto);
	
	// 답변달기글
	BoardDto breplyview(int bno);
	
	// 스텝증가
	void bstepUp(BoardDto bdto);

	// 답변달기 저장
	void breply(BoardDto bdto);
	
	// 이전게시글
	BoardDto selectOnePrev(int bno);
	
	// 다음게시글
	BoardDto selectOnenext(int bno);
	
	

}
