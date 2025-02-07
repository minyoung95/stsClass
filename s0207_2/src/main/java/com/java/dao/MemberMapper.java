package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;
import com.java.dto.MemberDto;

@Mapper // xml(sql구문)과 연결
public interface MemberMapper {

	// 인터페이스는 미완성메소드이므로 중괄호 제외
	ArrayList<MemberDto> memberSelect();
	
}
