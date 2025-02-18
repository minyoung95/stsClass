package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberBoardDto;

@Mapper
public interface MBMapper {

	ArrayList<MemberBoardDto> selectAll();

}
