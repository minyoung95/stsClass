package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface CMapper {

	ArrayList<BoardDto> selectAll(int startrow, int endrow);

	BoardDto selectOne(int bno);

	int countAll();

}
