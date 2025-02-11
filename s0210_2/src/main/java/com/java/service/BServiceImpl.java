package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Transactional // 함수가 실행되는동안 에러가 날 시 db에 수정될 부분을 롤백시켜줌(commit을 함수가 전부 실행되고 시켜줌)
@Service
public class BServiceImpl implements BService{

	@Autowired BoardMapper boardMapper;
	int rowPerPage = 10; // 한 페이지당 게시글 수
	
	// 게시판리스트
	@Override
	public Map<String, Object> blist(int page, String category, String searchW) {
		
		// 게시글, 검색어 갯수
		int count = boardMapper.countAll(category,searchW);
		
		// 페이지 넘버링
		int maxpage = (int)Math.ceil((double)count/rowPerPage);
		
		// 첫번쨰 페이지
		int startpage = (int)((page-1)/10)*10+1;
		
		// 마지막 페이지
		int endpage = startpage+10-1;
		if(endpage>maxpage) endpage=maxpage;
		
		// 페이지 별 검색번호
		int startrow = (page-1)*10+1;
		int endrow = startrow + rowPerPage -1;
		
		ArrayList<BoardDto> blist = boardMapper.blist(startrow,endrow,category,searchW);
		
		Map<String, Object> map = new HashMap<>();
		map.put("page",page);
		map.put("maxpage",maxpage);
		map.put("startpage",startpage);
		map.put("endpage",endpage);
		map.put("blist", blist);
		map.put("searchW", searchW);
		map.put("category", category);
		
		System.out.println("BoardMapper searchW : "+searchW);
		System.out.println("BoardMapper category : "+category);
		
		return map;
	}
	
	// 게시글 쓰기
	@Override
	public void bwrite(BoardDto dbto) {
		
		int result = boardMapper.bwrite(dbto);
		
	}
	
	// 게시글 1개 가져오기
	@Override
	public Map<String, Object> bview(int bno) {
		
		// boardDto와 prevDto, nextDto를 리턴값에 한번에 보내줄 수 없으므로 Map 사용
		Map<String, Object> map = new HashMap<>();
		
		// 조회수 1 증가 - update
		boardMapper.updateBhit(bno);
		// 현재 게시글
		BoardDto boardDto = boardMapper.bview(bno);
		// 이전 게시글
		BoardDto prevDto = boardMapper.selectOnePrev(bno);
		BoardDto nextDto = boardMapper.selectOnenext(bno);
		map.put("boardDto", boardDto);
		map.put("prevDto", prevDto);
		map.put("nextDto", nextDto);
		return map;
	}
	
	// 게시글 삭제
	@Override
	public void bdelete(int bno) {
		
		boardMapper.bdelete(bno);
	}
	
	// 게시글 수정
	@Override
	public BoardDto bupdate(int bno) {
		
		BoardDto boardDto = boardMapper.bupdateview(bno);
		return boardDto;
	}

	@Override
	public void bupdate(BoardDto bdto) {
		
		boardMapper.bupdate(bdto);
		
	}

	@Override
	public BoardDto breply(int bno) {
		
		BoardDto boardDto = boardMapper.breplyview(bno);
		return boardDto;
	}

	@Override
	public void breply(BoardDto bdto) {
		
		// 같은 그룹에서 부모보다 bstep이 높은 게시글 전부 bstep +1 증가
		boardMapper.bstepUp(bdto);
		
		// 답변달기 저장
		boardMapper.breply(bdto);
	}

}
