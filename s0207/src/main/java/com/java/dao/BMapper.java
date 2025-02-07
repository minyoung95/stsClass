package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

//@Repository // DAO(DB와 관련)

@Mapper // Mybatis : mapper/board/boardMapper.xml을 찾아감
public interface BMapper {

	ArrayList<BoardDto> blist();
	// BMapper 에서만 DB접근
	
}
