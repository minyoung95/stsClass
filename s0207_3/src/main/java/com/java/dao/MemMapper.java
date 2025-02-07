package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemDto;

@Mapper
public interface MemMapper {

	ArrayList<MemDto> mlist();

}
