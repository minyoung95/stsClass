package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;

@Mapper
public interface EMapper {

	ArrayList<EventDto> selectAll();

	EventDto selectOne(int eno);

	ArrayList<CboardDto> selectAllCboard(int eno);

	void insertCboard(CboardDto cdto);

	CboardDto selectOneCboard(int cno);

	void updateCboard(CboardDto cdto);

	void deleteCboard(int cno);

}
